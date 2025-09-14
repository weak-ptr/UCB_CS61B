package game2048;

import java.util.Random;

import ucb.util.CommandArgs;

/** The main class for the 2048 game.
 *  @author P. N. Hilfinger
 */
public class Main {

    /** Number of squares on the side of a board. */
    static final int BOARD_SIZE = 4;

    /** Probability of choosing 2 as random tile (as opposed to 4). */
    static final double TILE2_PROBABILITY = 0.9;

    /** The main program.  ARGS may contain the options --seed=NUM,
     *  (random seed); --log (record moves and random tiles
     *  selected.). */
    public static void main(String... args) {
        //  可选参数解析
        CommandArgs options = new CommandArgs("--seed=(\\d+) --log=(.+)", args);

        //  发现非法参数
        if (!options.ok()) {
            System.err.println("Usage: java game2048.Main [ --seed=NUM ] " + "[ --log=LOG_FILE ]");
            System.exit(1);
        }

        //  使用当前时间序列作为生成随机数的种子。
        Random gen = new Random();
        //  如果启动参数自带种子，使用启动参数的种子。
        if (options.contains("--seed")) {
            gen.setSeed(options.getLong("--seed"));
        }

        //  以参数4作为模型启动游戏。会生成一个4*4大小的面板，当前分数和记录设置为0，游戏状态位false。
        Model model = new Model(BOARD_SIZE);

        //  GUI is a TopLevel class，且必须实现Observer接口的update方法
        GUI gui;

        gui = new GUI("2048 61B", model);
        gui.display(true);

        //  输入接口
        InputSource inp;
        //  配置参数
        inp = new GUISource(gui, gen, TILE2_PROBABILITY, options.getFirst("--log"));

        //  使用模型和参数开启游戏
        Game game = new Game(model, inp);

        try {
            while (game.playing()) {
                game.playGame();
            }
        } catch (IllegalStateException excp) {
            System.err.printf("Internal error: %s%n", excp.getMessage());
            System.exit(1);
        }

        System.exit(0);
    }
}
