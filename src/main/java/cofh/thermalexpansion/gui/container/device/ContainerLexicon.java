package cofh.thermalexpansion.gui.container.device;

import cofh.core.gui.slot.ISlotValidator;
import cofh.core.gui.slot.SlotFalseCopy;
import cofh.core.gui.slot.SlotRemoveOnly;
import cofh.core.gui.slot.SlotValidated;
import cofh.thermalexpansion.block.device.TileLexicon;
import cofh.thermalexpansion.gui.container.ContainerTEBase;
import cofh.thermalexpansion.gui.slot.SlotLexicon;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ContainerLexicon extends ContainerTEBase implements ISlotValidator {

	protected TileLexicon myTile;

	public ContainerLexicon(InventoryPlayer inventory, TileEntity tile) {

		super(inventory, tile);

		myTile = (TileLexicon) tile;
		addSlotToContainer(new SlotValidated(this, myTile, 0, 26, 35));
		addSlotToContainer(new SlotRemoveOnly(myTile, 1, 134, 35));

		/* Custom Inventory */
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				addSlotToContainer(new SlotLexicon(myTile, null, j + i * 3, 62 + j * 18, 17 + i * 18));
			}
		}
	}

	@Override
	public boolean isItemValid(ItemStack stack) {

		return myTile.hasPreferredStack(stack);
	}

}
