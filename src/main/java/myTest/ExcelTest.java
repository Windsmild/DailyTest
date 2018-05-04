package myTest;

import com.google.common.collect.Lists;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Stephen Cai
 * @date 2018-03-28 13:35
 */
public class ExcelTest {
    @Data
    static class ChoiceWithRight {
        String choice;
        String content;
        boolean right;
    }

    public static void millionHero() throws Exception{
        Workbook workbook = WorkbookFactory.create(new File("/Users/caifeng/Downloads/题库667.2.xlsx"));
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
            for (int i = 1; i <= 400 ; i++) {
                Row row = sheet.getRow(i);
                StringBuilder sb = new StringBuilder();
                sb.append("INSERT INTO `PN_MillionHeroQuestion` (`campaignId`, `title`, `choices`, `addTime`, `updateTime`)\n"
                    + "VALUES (667,\'"+row.getCell(0)+"\', \'[");
                //sb.append("update `PN_MillionHeroQuestion` set choices = \'[");
                String answer = row.getCell(5).toString().toUpperCase().replace('\u00A0', ' ').trim();
                if (answer.equals("A")) {
                    sb.append("{\"choice\":\"A\",\"content\":\"" + row.getCell(1).toString() + "\",\"right\":true},");
                } else {
                    sb.append("{\"choice\":\"A\",\"content\":\"" + row.getCell(1).toString() + "\"},");
                }

                if (answer.equals("B")) {
                    sb.append("{\"choice\":\"B\",\"content\":\"" + row.getCell(2).toString() + "\",\"right\":true},");
                } else {
                    sb.append("{\"choice\":\"B\",\"content\":\"" + row.getCell(2).toString() + "\"},");
                }
                if (answer.equals("C")) {
                    sb.append("{\"choice\":\"C\",\"content\":\"" + row.getCell(3).toString() + "\",\"right\":true},");
                } else {
                    sb.append("{\"choice\":\"C\",\"content\":\"" + row.getCell(3).toString() + "\"},");
                }
                if (answer.equals("D")) {
                    sb.append("{\"choice\":\"D\",\"content\":\"" + row.getCell(4).toString() + "\",\"right\":true}");
                } else {
                    sb.append("{\"choice\":\"D\",\"content\":\"" + row.getCell(4).toString() + "\"}");
                }
                sb.append("]\',now(),now());");
                //sb.append("]\' where title = \""+row.getCell(0)+ "\";");
                System.out.println(sb.toString());
                if (!sb.toString().contains("true")) {
                    System.out.println("不包含正确回答！！");
                    break;
                }
            }
        });
        System.out.println(workbook.getAllNames());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    static class Answer {
        private int questionId;
        private int choice;
        private String title;
    }

    public static void toMap() {
        List<Answer> answers = Lists.newArrayList();
        answers.add(new Answer(1,11,"大佬"));
        answers.add(new Answer(2,22,"laoer"));
        answers.add(new Answer(1,33,"niba"));
        answers.add(new Answer(1,44,"niba"));
        Map<Integer, Integer> choiceMap = answers.stream().collect(Collectors.toMap(Answer::getQuestionId, Answer::getChoice, (c1,c2) -> c1+c2));
        System.out.println(choiceMap);
        choiceMap.get("");
    }

    public static void main(String[] args) throws Exception {
        //toMap();
        millionHero();
    }
}

