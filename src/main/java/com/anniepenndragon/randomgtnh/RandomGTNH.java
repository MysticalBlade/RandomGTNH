package com.anniepenndragon.randomgtnh;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.anniepenndragon.randomgtnh.blocks.GamerBlock;
import com.anniepenndragon.randomgtnh.items.Estrogen;
import com.anniepenndragon.randomgtnh.items.emeraldAxe;
import com.anniepenndragon.randomgtnh.items.emeraldHoe;
import com.anniepenndragon.randomgtnh.items.emeraldPickaxe;
import com.anniepenndragon.randomgtnh.items.emeraldShovel;
import com.anniepenndragon.randomgtnh.items.emeraldSword;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

@Mod(modid = RandomGTNH.MODID, version = "1.0", name = "RandomGTNH", acceptedMinecraftVersions = "[1.7.10]")
public class RandomGTNH {

    public static Item Estrogen;
    public static Item emeraldSword;
    public static Item emeraldAxe;
    public static Item emeraldShovel;
    public static Item emeraldPickaxe;
    public static Item emeraldHoe;

    public static final Item.ToolMaterial emeraldToolMaterial = EnumHelper
        .addToolMaterial("emeraldToolMaterial", 7, 2700, 12.0F, 7.0F, 15);

    public static Block GamerBlock;

    public static final String MODID = "RandomGTNH";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(
        clientSide = "com.anniepenndragon.randomgtnh.ClientProxy",
        serverSide = "com.anniepenndragon.randomgtnh.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc., and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {

        // Item Initialization
        Estrogen = new Estrogen().setUnlocalizedName("ItemTable")
            .setTextureName("randomgtnh:estrogen")
            .setCreativeTab(tabsRandomGTNH);
        GameRegistry.registerItem(
            Estrogen,
            Estrogen.getUnlocalizedName()
                .substring(5));

        // Blocks Initialization
        GamerBlock = new GamerBlock(Material.wood).setBlockName("GamerBlock")
            .setBlockTextureName("randomgtnh:gamer")
            .setCreativeTab(tabsRandomGTNH);
        GameRegistry.registerBlock(
            GamerBlock,
            GamerBlock.getUnlocalizedName()
                .substring(5));

        // Tool Initialization
        emeraldPickaxe = new emeraldPickaxe(emeraldToolMaterial).setUnlocalizedName("emeraldPickaxe")
            .setTextureName("randomgtnh:emeraldPickaxe")
            .setCreativeTab(tabsRandomGTNH);
        GameRegistry.registerItem(
            emeraldPickaxe,
            emeraldPickaxe.getUnlocalizedName()
                .substring(5));

        emeraldAxe = new emeraldAxe(emeraldToolMaterial).setUnlocalizedName("emeraldAxe")
            .setTextureName("randomgtnh:emeraldAxe")
            .setCreativeTab(tabsRandomGTNH);
        GameRegistry.registerItem(
            emeraldAxe,
            emeraldAxe.getUnlocalizedName()
                .substring(5));

        emeraldShovel = new emeraldShovel(emeraldToolMaterial).setUnlocalizedName("emeraldShovel")
            .setTextureName("randomgtnh:emeraldShovel")
            .setCreativeTab(tabsRandomGTNH);
        GameRegistry.registerItem(
            emeraldShovel,
            emeraldShovel.getUnlocalizedName()
                .substring(5));

        emeraldSword = new emeraldSword(emeraldToolMaterial).setUnlocalizedName("emeraldSword")
            .setTextureName("randomgtnh:emeraldSword")
            .setCreativeTab(tabsRandomGTNH);
        GameRegistry.registerItem(
            emeraldSword,
            emeraldSword.getUnlocalizedName()
                .substring(5));

        emeraldHoe = new emeraldHoe(emeraldToolMaterial).setUnlocalizedName("emeraldHoe")
            .setTextureName("randomgtnh:emeraldHoe")
            .setCreativeTab(tabsRandomGTNH);
        GameRegistry.registerItem(
            emeraldHoe,
            emeraldHoe.getUnlocalizedName()
                .substring(5));
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        GameRegistry.addRecipe(new ItemStack(Estrogen), "MMM", "MMM", "MMM", 'M', Items.milk_bucket);
        GameRegistry
            .addRecipe(new ItemStack(emeraldPickaxe), "EEE", " S ", " S ", 'E', Items.emerald, 'S', Items.stick);
        GameRegistry.addRecipe(new ItemStack(emeraldShovel), " E ", " S ", " S ", 'E', Items.emerald, 'S', Items.stick);
        GameRegistry.addRecipe(new ItemStack(emeraldSword), " E ", " E ", " S ", 'E', Items.emerald, 'S', Items.stick);
        GameRegistry.addRecipe(new ItemStack(emeraldAxe), " EE", " SE", " S ", 'E', Items.emerald, 'S', Items.stick);
        GameRegistry.addRecipe(new ItemStack(emeraldHoe), " EE", " S ", " S ", 'E', Items.emerald, 'S', Items.stick);
        GameRegistry.addRecipe(
            new ItemStack(emeraldHoe),
            " EE",
            " S ",
            " S ",
            'E',
            GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Neutronium, 1),
            'S',
            Items.stick);

    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {

    }

    public static CreativeTabs tabsRandomGTNH = new CreativeTabs("tabsRandomGTNH") {

        @Override
        public Item getTabIconItem() {
            return new ItemStack(Estrogen).getItem();
        }
    };

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
