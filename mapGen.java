import GLOOP.*;
import org.json.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class mapGen {
        static GLOOP_object_generator GLOOP_gen=new GLOOP_object_generator();
        JSONObject mapObj;
        int mapSizeX, mapSizeY, mapScale, winX, winY;
        public void parseMapJSON(String mapJSON){
            mapObj=new JSONObject(mapJSON);
            mapSizeX=mapObj.getInt("sizeX");
            mapSizeY=mapObj.getInt("sizeY");
            winX = mapObj.getInt("winX");
            winY = mapObj.getInt("winY");
            mapScale=mapObj.getInt("mapScale");
            GLOOP_gen.createWinBlock(winX, winY, mapScale);
            for(int iX=1;iX<=mapSizeX;iX++){
                for(int iY=1;iY<=mapSizeY;iY++){
                    try {
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
                        // this shouldn't be possible
                        // probably faulty generation file
                        // or the map generator was fucked up
                    break;
                    }
                    } catch (Exception e) {
                        System.out.println("No Map Data at " + iX +" " + iY);
                    }
                }
            }
        }
        public boolean canMoveTo(int x, int y) {
                            System.out.println("Can Move to" + x + " " + y);
                            
            try {
                String nameString = x+"_"+y;
                System.out.println("String is " + nameString.replaceAll("\\.0*$", ""));

            if (mapObj.getJSONObject("map_data").getJSONObject(nameString.replaceAll("\\.0*$", "")).getString("entity_type") == "exit") {
                // win
                                System.out.println("yes, win");
                return true;

            } else if (mapObj.getJSONObject("map_data").getJSONObject(nameString.replaceAll("\\.0*$", "")).getBoolean("collide")) {
                                System.out.println("no, collide " + mapObj.getJSONObject("map_data").getJSONObject(nameString.replaceAll("\\.0*$", "")).getBoolean("collide"));
                                
                return false;
            } else {
                                System.out.println("yes, no collide");
                return true;
            }
            } catch (Exception e) {
                System.out.println("Yes, not defined");
                return true;
            }
        }
        public int winX() {
            return winX;
        }
        public int winY() {
            return winY;
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
