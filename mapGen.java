import GLOOP.*;
import org.json.*;

mapGen {
    parseMapJSON(String mapJSON) {
        JSONObject mapObj = new JSONObject(mapJSON);
        int mapSizeX = mapObj.getInt("sizeX");
        int mapSizeY = mapObj.getInt("sizeY");
        for (int iX = 0; iX < mapSizeX; iX++) {
            for (int iY = 0; iY < mapSizeY; iY++) {
                Object currentMapTile = mapObj.getObject("map-data").getObject(iX + "-" + iY);
                switch (currentMapTile.getString("entitiy-type")){
                    case"block":
                        // Generate a new Block at position from JSON Object
                        break;
                    case "ground":
                        // Create new walkable floor
                        if(currentMapTile.getBoolean("hasEntity")){
                        // Ground Position has Entitiy
                        }
                        break;
                    case "hole":
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