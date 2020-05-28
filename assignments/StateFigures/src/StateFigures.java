import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateFigures extends JFrame {
    private HashMap<String, ArrayList<Figure>> data = new HashMap<String, ArrayList<Figure>>();
    static Map<Integer, String> states = new HashMap<Integer, String>();

    public StateFigures(ArrayList<Figure> stateData){
        setSize(1140, 600);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        initFipsCode();
        for (Figure e:stateData) {
            if (this.data.get(states.get(e.getFips())) == null){
                ArrayList<Figure> temp = new ArrayList<>();
                temp.add(e);
                data.put(states.get(e.getFips()), temp);
            } else {
                data.get(states.get(e.getFips())).add(e);
            }
        }
    }

    private static void initFipsCode(){
        states.put(1, "Alabama");
        states.put(2, "Alaska");
        states.put(3, "American Samoa");
        states.put(4, "Arizona");
        states.put(5, "Arkansas");
        states.put(6, "California");
        states.put(8, "Colorado");
        states.put(9, "Connecticut");
        states.put(10, "Delaware");
        states.put(11, "District Of Columbia");
        states.put(12, "Florida");
        states.put(13, "Georgia");
        states.put(14, "Guam");
        states.put(15, "Hawaii");
        states.put(16,"Idaho");
        states.put(17, "Illinois");
        states.put(18, "Indiana");
        states.put(19, "Iowa");
        states.put(20,"Kansas");
        states.put(21, "Kentucky");
        states.put(22, "Louisiana");
        states.put(23, "Maine");
        states.put(24, "Maryland");
        states.put(25, "Massachusetts");
        states.put(26, "Michigan");
        states.put(27, "Minnesota");
        states.put(28, "Mississippi");
        states.put(29, "Missouri");
        states.put(30, "Montana");
        states.put(31, "Nebraska");
        states.put(32, "Nevada");
        states.put(33, "New Hampshire");
        states.put(34, "New Jersey");
        states.put(35, "New Mexico");
        states.put(36, "New York");
        states.put(37, "North Carolina");
        states.put(38, "North Dakota");
        states.put(39, "Ohio");
        states.put(40, "Oklahoma");
        states.put(41, "Oregon");
        states.put(42, "Pennsylvania");
        states.put(43, "Puerto Rico");
        states.put(44, "Rhode Island");
        states.put(45, "South Carolina");
        states.put(46, "South Dakota");
        states.put(47, "Tennessee");
        states.put(48, "Texas");
        states.put(49, "Utah");
        states.put(50, "Vermont");
        states.put(51, "Virgin Islands");
        states.put(52, "Virginia");
        states.put(53, "Washington");
        states.put(54, "West Virginia");
        states.put(55, "Wisconsin");
        states.put(56, "Wyoming");
    }



    private void plotStateCases(String state, Graphics g) {

        for(Figure stateFigure: data.get(state)) {
            int x = stateFigure.getDay();
            int y = stateFigure.getCases();
            g.setColor(Color.BLACK);
            g.fillOval(x*6, 500 - y/20,  10, 10);

        }

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many figures?");
        int numDates = scanner.nextInt();

        String[][] partData = new String[numDates][3];
        ArrayList<Figure> data = new ArrayList<>();

        for(int i = 0; i < numDates; i++) {
            System.out.print("year");
            String year = scanner.next();
            partData[i][0] = year;
            System.out.print("month");
            String month = scanner.next();
            partData[i][1] = month;
            System.out.print("day");
            String day = scanner.next();
            partData[i][2] = day;
            int date = Figure.ifromdate(partData[i]);

            System.out.println("fips");
            int fips = Integer.parseInt(scanner.next());

            System.out.println("cases");
            int cases = Integer.parseInt(scanner.next());

            System.out.println("deaths");
            int deaths = Integer.parseInt(scanner.next());

            Figure dataPoint = new Figure(date, fips, cases, deaths);
            data.add(dataPoint);
            System.out.println(dataPoint);
        }

//        System.out.println("Day to find total deaths");
//        int day = Integer.parseInt(scanner.next());
//        int totalDeaths = Figure.getTotalDeathsOnDay(data, day);
//        System.out.println("Total Deaths: " + totalDeaths)
        StateFigures storingData = new StateFigures(data);
        storingData.repaint();
    }

    @Override
    public void paint(Graphics g){
        plotStateCases("Washington", g);
    }
}
