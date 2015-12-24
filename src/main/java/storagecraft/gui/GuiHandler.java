package storagecraft.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import storagecraft.StorageCraft;
import storagecraft.container.ContainerController;
import storagecraft.container.ContainerDetector;
import storagecraft.container.ContainerDrive;
import storagecraft.container.ContainerExporter;
import storagecraft.container.ContainerGrid;
import storagecraft.container.ContainerImporter;
import storagecraft.container.ContainerSolderer;
import storagecraft.container.ContainerExternalStorage;
import storagecraft.container.ContainerWirelessTransmitter;
import storagecraft.tile.TileController;
import storagecraft.tile.TileDetector;
import storagecraft.tile.TileDrive;
import storagecraft.tile.TileExporter;
import storagecraft.tile.TileGrid;
import storagecraft.tile.TileImporter;
import storagecraft.tile.TileSolderer;
import storagecraft.tile.TileExternalStorage;
import storagecraft.tile.TileWirelessTransmitter;

public class GuiHandler implements IGuiHandler
{
	private Container getContainer(int ID, EntityPlayer player, TileEntity tile)
	{
		switch (ID)
		{
			case StorageCraft.GUI.CONTROLLER:
				return new ContainerController(player);
			case StorageCraft.GUI.GRID:
				return new ContainerGrid(player, (TileGrid) tile);
			case StorageCraft.GUI.DRIVE:
				return new ContainerDrive(player, (TileDrive) tile);
			case StorageCraft.GUI.EXTERNAL_STORAGE:
				return new ContainerExternalStorage(player);
			case StorageCraft.GUI.IMPORTER:
				return new ContainerImporter(player, (TileImporter) tile);
			case StorageCraft.GUI.EXPORTER:
				return new ContainerExporter(player, (TileExporter) tile);
			case StorageCraft.GUI.DETECTOR:
				return new ContainerDetector(player, (TileDetector) tile);
			case StorageCraft.GUI.SOLDERER:
				return new ContainerSolderer(player, (TileSolderer) tile);
			case StorageCraft.GUI.WIRELESS_TRANSMITTER:
				return new ContainerWirelessTransmitter(player, (TileWirelessTransmitter) tile);
			default:
				return null;
		}
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return getContainer(ID, player, world.getTileEntity(x, y, z));
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(x, y, z);

		switch (ID)
		{
			case StorageCraft.GUI.CONTROLLER:
				return new GuiController((ContainerController) getContainer(ID, player, tile), (TileController) tile);
			case StorageCraft.GUI.GRID:
				return new GuiGrid((ContainerGrid) getContainer(ID, player, tile), (TileGrid) tile);
			case StorageCraft.GUI.DRIVE:
				return new GuiDrive((ContainerDrive) getContainer(ID, player, tile), (TileDrive) tile);
			case StorageCraft.GUI.EXTERNAL_STORAGE:
				return new GuiExternalStorage((ContainerExternalStorage) getContainer(ID, player, tile), (TileExternalStorage) tile);
			case StorageCraft.GUI.IMPORTER:
				return new GuiImporter((ContainerImporter) getContainer(ID, player, tile), (TileImporter) tile);
			case StorageCraft.GUI.EXPORTER:
				return new GuiExporter((ContainerExporter) getContainer(ID, player, tile), (TileExporter) tile);
			case StorageCraft.GUI.DETECTOR:
				return new GuiDetector((ContainerDetector) getContainer(ID, player, tile), (TileDetector) tile);
			case StorageCraft.GUI.SOLDERER:
				return new GuiSolderer((ContainerSolderer) getContainer(ID, player, tile), (TileSolderer) tile);
			case StorageCraft.GUI.WIRELESS_TRANSMITTER:
				return new GuiWirelessTransmitter((ContainerWirelessTransmitter) getContainer(ID, player, tile), (TileWirelessTransmitter) tile);
			default:
				return null;
		}
	}
}
