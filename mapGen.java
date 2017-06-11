import GLOOP.*;
import org.json.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class mapGen {
        static GLOOP_object_generator GLOOP_gen=new GLOOP_object_generator();
        public static void parseMapJSON(String mapJSON){
            JSONObject mapObj=new JSONObject(mapJSON);
            int mapSizeX=mapObj.getInt("sizeX");
            int mapSizeY=mapObj.getInt("sizeY");
            int mapScale=mapObj.getInt("mapScale");

            for(int iX=1;iX<=mapSizeX;iX++){
                for(int iY=1;iY<=mapSizeY;iY++){
                    JSONObject currentMapTile=mapObj.getJSONObject("map_data").getJSONObject(iX+"_"+iY);
                    System.out.println(currentMapTile.getString("entity_type") + " at " + iX + " " + iY);
                    switch(currentMapTile.getString("entity_type")){
                    case"block":
                        // Generate a new Block at position from JSON Object
                        GLOOP_gen.createBlock(iX,iY,mapScale);
                    break;
                    case"ground":
                        // Create new walkable floor
                    if(currentMapTile.getBoolean("hasEntity")){
                        // Ground Position has Entitiy

                    }
                    break;
                    case"hole":
                        // Generate hole (aka. just an empty entity)
                    break;
                    default:
                        // what the fuck this shouldn't be possible
                        // probably faulty generation file
                        // or the map generator was fucked up
                        System.out.println("What the F U C K " + iX +" " + iY);
                    break;
                    }
                }
            }
        }
    public void generateFromFile(String FILENAME){

        BufferedReader br = null;
        FileReader fr = null;
        String inFile="";
        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(FILENAME));

            while ((sCurrentLine = br.readLine()) != null) {
                inFile += sCurrentLine + "\n";
            }
            this.parseMapJSON(inFile);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
