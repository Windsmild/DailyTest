package myTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Stephen Cai on 2017-09-03 13:54.
 */
public class RegTest {
    private static final String URL_ANSWERS = "https://www\\.zhihu\\.com/people/.*/answers";

    public static String rawHtml = "<html>\n"
        + " <head></head> \n"
        + " <body> \n"
        + "  <p style=\"margin: 0em 0.5em; line-height: 1.75em; text-align: center;\"><span style=\"color:#FFFFFF\"><span style=\"font-size:14px\"><span style=\"background-color:#FFA500\">mini音乐节</span></span></span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; text-align: justify; line-height: 1.75em;\"><br style=\"font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <span style=\"font-size:14px\">mini音乐节是凯迪拉克•上海音乐厅于2013年策划推出的一个室内音乐会，每年以围绕一个主题，连续举办3~4场演出及讲座的形式，让听众能够在短时间内一种音乐风格进行初步了解。</span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; text-align: justify; line-height: 1.75em;\"><br style=\"font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <span style=\"font-size:14px\">2018年mini音乐节的主题为“古乐”。凯迪拉克•上海音乐厅精选了汉堡议会音乐家合奏团、绅士合奏团、欧洲嘉兰古乐团三个不同规模的古乐团，以三场室内乐演出为上海乐迷们展会巴洛克时期年代不一，风格迥异的作品。<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 鸟，是巴洛克音乐里的最常见的元素。维瓦尔第、亨德尔、凡•爱克、凯泽、托里等作曲家的众多作品中，鸟的元素比比皆是。</span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; text-align: justify; line-height: 1.75em;\"><br style=\"font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <span style=\"font-size:14px\">史戴芬•谭明恩、朵洛西•梅尔蒂与绅士合奏团将在音乐会中用古乐器模仿各种各样的鸟类声音，如夜莺、杜鹃、鸡、鸽子等，时而激昂华丽，时而有趣亢奋，又时而温婉动人，演绎关于“鸟”主题的巴洛克音乐。</span><br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> &nbsp;</p> \n"
        + "  <p style=\"margin: 0em 0.5em; line-height: 1.75em; text-align: center;\"><span style=\"color:#FFFFFF\"><span style=\"font-size:14px\"><span style=\"background-color:#FFA500\">艺术家介绍</span></span></span></p> \n"
        + "  <p>&nbsp;</p> \n"
        + "  <p style=\"margin: 0em 0.5em; line-height: 1.75em; text-align: center;\"><span style=\"color:#DAA520\"><span style=\"font-size:14px\">史戴芬•谭明恩, 牧童笛</span></span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; text-align: justify; line-height: 1.75em;\"><span style=\"font-size:14px\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 史戴芬•谭明恩，新生代牧童笛大师。意大利米兰《晚邮报》在他蜚声国际的处女作唱片《摩登科雷利》上点评道：“从未见过如此轻快的牧童笛演奏，音色多变、富有动感。”&nbsp;</span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; line-height: 1.75em;\"><span style=\"font-size:14px\">2009年，《摩登科雷利》蜚声国际。两年后，他的第二张CD《绅士的长笛》刚发行便提名为国际古典音乐奖（前身为法国戛纳国际唱片展大奖）。这一瞩目成就，让他一跃成为古典乐坛新秀。之后，他与另外五位志同道合的演奏家共同组成绅士合奏团。2014年，他与女高音朵洛西•梅尔蒂连同绅士合奏团所创作的新唱片《灵感美声》由索尼发行。在古乐方面的贡献，乐界人士将他与古乐界传奇前辈布鲁根(Frans Brüggen)相提并论，将他誉为布鲁根的接班人。</span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; line-height: 1.75em; text-align: center;\"><br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <span style=\"font-size:14px\"><span style=\"color:#DAA520\">朵洛西•梅尔蒂, 女高音&nbsp; &nbsp;</span>&nbsp;&nbsp; &nbsp; &nbsp;</span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; text-align: justify; line-height: 1.75em;\"><span style=\"font-size:14px\">&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 朵洛西•梅尔蒂，17、18世纪时期的音乐领军人物之一，因其独特的音色和动人的演绎而深受观众和评论家爱戴。</span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; line-height: 1.75em;\"><span style=\"font-size:14px\">2013年6月，大卫•维客斯在《留声机》写道：“难以想象目前有哪个德国巴洛克风的女高音能与梅尔蒂媲美。她美妙的音色与奏乐契合，诗意又平稳的演绎，简直令人赏心悦目。”她精湛的歌技，清透又空灵的声音使她成为当代作曲家的理想人选。因此，《灵感美声》与《鸟》能邀请到朵洛西•梅尔蒂献唱无疑是明智之举。</span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; line-height: 1.75em; text-align: center;\"><br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <span style=\"font-size:14px\"><span style=\"color:#DAA520\">绅士合奏团 </span></span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; line-height: 1.75em;\"><span style=\"font-size:14px\">&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 玛格丽特•可儿／古竖琴&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 维博克•魏丹茨／羽管键琴&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 道门•马瑞斯科／古大提琴&amp;巴洛克大提琴&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 迈克尔•迪克／诗琴</span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; line-height: 1.75em; text-align: center;\"><br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <span style=\"font-size:14px\"><span style=\"color:#FFFFFF\"><span style=\"background-color:#FFA500\">史戴芬.谭明恩与朵洛西.梅尔蒂</span><br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <span style=\"background-color:#FFA500\">携手绅士和奏团（竖琴，琵琶，羽管键琴，低音维奥尔琴）</span></span></span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; text-align: justify; line-height: 1.75em;\"><br style=\"font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <span style=\"font-size:14px\">关于鸟的主题的巴洛克音乐，是牧童笛巨星史戴芬•谭明恩携手他的乐团“绅士合奏团”及知名女高音朵洛西•梅尔蒂推出的新唱片的主题。这个主题十分契合两位独奏家的喜好：朵洛西•梅尔蒂热爱鸟类，而星史戴芬•谭明恩的祖国南非则以其丰富多彩的鸟类闻名于世，是观鸟者的天堂。鸟，是巴洛克音乐里的最常见的元素。维瓦尔第、亨德尔、凡•爱克、凯泽、托里等作曲家的众多作品中，鸟的元素也比比皆是。</span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; text-align: justify; line-height: 1.75em;\"><br style=\"font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <span style=\"font-size:14px\">我们可以听到各种各样的鸟类声音，如夜莺、杜鹃、鸡、鸽子等。那音乐时而激昂华丽，时而有趣亢奋，又时而温婉动人。当然，这次表演不只是重现鸟的声音——通常主题或多或少都与爱和春天有关。几个世纪以来，人们对一些鸟类总有某种特殊的情感，而各类的鸟都有着其独特的象征意义，如夜莺代表纯洁和爱情的美好，杜鹃则代表的背叛。</span><br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> &nbsp;</p> \n"
        + "  <p style=\"margin: 0em 0.5em; line-height: 1.75em; text-align: center;\"><span style=\"color:#FFFFFF\"><span style=\"font-size:14px\"><span style=\"background-color:#FFA500\">曲目</span></span></span></p> \n"
        + "  <p><span style=\"font-size:14px\">\u200B</span></p> \n"
        + "  <p style=\"margin: 0em 0.5em; text-align: justify; line-height: 1.75em;\"><span style=\"font-size:14px\">皮特罗•托里&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 夜莺，选自《伊斯梅内》&nbsp; &nbsp;为女高音、牧童笛、通奏低音而作<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 安东尼奥•维瓦尔第&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 春天：广板&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;简- 雅克•卢梭为长笛独奏而改编<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 夸尼先生&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 春天：温柔，选自《咏叹调与祝酒歌第九卷》&nbsp; 为女高音、牧童笛、通奏低音而作<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 托马斯•奥古斯丁•阿恩&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 布谷鸟，选自《如愿》&nbsp; &nbsp; 为女高音、通奏低音而作<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 约翰•海因里希•施梅尔策&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 布谷鸟奏鸣曲&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;为牧童笛、通奏低音而作<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 马修•洛克&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 孔雀舞曲，选自第3号D小调/ D大调组曲&nbsp; 为牧童笛、通奏低音而作<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 匿名&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 三只乌鸦，选自《装饰音》<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 格奥尔格•弗里德里希•汉德尔&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 可爱的鸟儿，选自《快乐、哀愁和中庸》作品号55<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 中场休息<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 匿名&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 这个愉快的春天<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 格奥尔格•菲利普•泰勒曼&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 幻想曲12号&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 为牧童笛独奏而作<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 赖因哈德•凯泽&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 愉快的夜莺，选自《尤利西斯》&nbsp; &nbsp; &nbsp; &nbsp;为女高音、2个牧童笛、通奏低音而作<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 亚历山德罗•波格蒂&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 模仿鸟鸣（夜莺），选自《夜莺》&nbsp; &nbsp;为羽管键琴独奏而作<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 雅各布•范艾克&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 英国夜莺，选自《愉悦的笛园》&nbsp; &nbsp; 为牧童笛独奏而作<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 约翰•巴特&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 可爱的鸟儿永远不会离开我，选自《艾列斯之书》&nbsp; &nbsp;为女高音、低音维奥尔琴、通奏低音而作<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 第一章&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 第二章<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 第三章<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 朱塞佩•费德勒利&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 享受鸟鸣，选自《爱情神殿》&nbsp; 为女高音、牧童笛、通奏低音而作<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> 广板-柔板-广板-快板-活泼-柔板-快板-慢板<br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> <br style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"> *曲目以当天演出为准</span></p>  \n"
        + " </body>\n"
        + "</html>";

    public static int matcherInt(String pattern, String source) {
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(source);
        matcher.find();
        int result = -1;
        try {
            result = Integer.parseInt(matcher.group(1));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void matchImg() {
        Pattern p = Pattern.compile("<img?(.+)?\\s*\\/>");
        Matcher m = p.matcher("<img src=\"http://google.com\"/>");

        if (m.find()) {
            System.out.println(m.group(1));
        }
    }

    public static void repplaceDot() {
        String s = "童心飞扬•蓉城春芽--周末亲子剧场演出季《熊熊探案-加油，精灵》";
        s = s.replace("•", "·12312");
        //s.replace("童心", "child");
        System.out.println(s);
    }

    /**
     * 将img标签中的src进行二次包装
     */
    public static String replaceHtmlImg(String rawHtml) {
        String patternStr = "<img\\s*([^>]*)\\s*src=\\\"(.*?)\\\"\\s*([^>]*)>";
        Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(rawHtml);
        String result = rawHtml;
        while (matcher.find()) {
            String src = matcher.group(2);
            String replaceSrc = "https://360buy.img.com";
            result = result.replaceAll(src, replaceSrc);
        }
        System.out.println(result);
        return result;
    }

    private static String replace_src(String rawString) {
        Pattern imgPattern = Pattern.compile("(_src=\\\".*?\\\")", Pattern.CASE_INSENSITIVE);
        Matcher matcher = imgPattern.matcher(rawString);
        String result = rawString;
        while (matcher.find()) {
            String _src = matcher.group(1);
            result = result.replaceAll(_src, "");
        }
        return result;
    }

    private static String replaceFontSize(String rawString) {
        Pattern imgPattern = Pattern.compile("(font-size:.*?px;)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = imgPattern.matcher(rawString);
        String result = rawString;
        while (matcher.find()) {
            String _src = matcher.group(1);
            result = result.replace(_src, "");
        }

        Pattern imgPattern2 = Pattern.compile("(font-size:.*?px)", Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = imgPattern2.matcher(result);
        while (matcher2.find()) {
            String _src = matcher2.group(1);
            result = result.replace(_src, "");
        }
        return result;
    }

    public static String replaceBracket(String address) {
        Pattern pattern = Pattern.compile("[\\(\\（].*?[\\)\\）]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(address);
        String result = address;
        while (matcher.find()) {
            String toReplace = matcher.group(0);
            result = result.replace(toReplace, "");
        }
        return result;
    }

    private final static String MobileNoPattern = "^1\\d{10}$";

    public static void mobileNo () {
        System.out.println( Pattern.matches(MobileNoPattern, "16606216996"));
        System.out.println( Pattern.matches(MobileNoPattern, "18516246686"));

    }
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        //mobileNo();
        //replaceHtmlImg();
        //replace_src(rawHtml);
        //replaceFontSize(rawHtml);
        //replaceBracket("上海市浦东新区金藏路58号(吃了吗)()（你好）（红星美凯龙家居艺术设计博览中心F7）(吃了吗)");
    }
}
