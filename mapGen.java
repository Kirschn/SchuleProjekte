import GLOOP.*;
import org.json.*;
import java.nio.file;
public class mapGen{
        GLOOP_object_generator GLOOP_gen=new GLOOP_object_generator();
        public void parseMapJSON(String mapJSON){
        JSONObject mapObj=new JSONObject(mapJSON);
        int mapSizeX=mapObj.getInt("sizeX");
        int mapSizeY=mapObj.getInt("sizeY");
        int mapScale=mapObj.getInt("mapScale");

        for(int iX=0;iX<mapSizeX;iX++){
        for(int iY=0;iY<mapSizeY;iY++){
        Object currentMapTile=mapObj.getObject("map-data").getObject(iX+"_"+iY);
        switch(currentMapTile.getString("entitiy-type")){
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

        default:
        // what the fuck this shouldn't be possible
        // probably faulty generation file
        // or the map generator was fucked up
        break;
        }
        }
        }
        }
    public void generateFromFile(String path){
        Charset charset=Charset.forName("UTF-8");
        String inFile="";
        try(BufferedReader reader=Files.newBufferedReader(path,charset)){
            String line=null;
            while((line=reader.readLine())!=null){
                inFile+=line+"\n";
            }
            this.parseMapJSON(inFile);

        } catch(IOException x){
                System.err.format("IOException: %s%n",x);
            }
    }
}
