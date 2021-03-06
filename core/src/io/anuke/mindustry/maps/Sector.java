package io.anuke.mindustry.maps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import io.anuke.mindustry.game.Saves.SaveSlot;
import io.anuke.mindustry.game.SpawnGroup;
import io.anuke.mindustry.maps.goals.Mission;
import io.anuke.mindustry.maps.goals.WaveMission;
import io.anuke.mindustry.type.Item;
import io.anuke.ucore.util.Bits;

import static io.anuke.mindustry.Vars.control;

public class Sector{
    /**Position on the map, can be positive or negative.*/
    public short x, y;
    /**Whether this sector has already been completed.*/
    public boolean complete;
    /**Slot ID of this sector's save. -1 means no save has been created.*/
    public int saveID = -1;
    /**Sector size; if more than 1, the coordinates are the bottom left corner.*/
    public int size = 1;
    /**Display texture. Needs to be disposed.*/
    public transient Texture texture;
    /**Mission of this sector-- what needs to be accomplished to unlock it.*/
    public transient Mission mission = new WaveMission(30);
    /**Enemies spawned at this sector.*/
    public transient Array<SpawnGroup> spawns = new Array<>();
    /**Ores that appear in this sector.*/
    public transient Array<Item> ores = new Array<>();

    public int getSeed(){
        return Bits.packInt(x, y);
    }

    public SaveSlot getSave(){
        return control.getSaves().getByID(saveID);
    }

    public boolean hasSave(){
        return control.getSaves().getByID(saveID) != null;
    }

    public int packedPosition(){
        return Bits.packInt(x, y);
    }
}
