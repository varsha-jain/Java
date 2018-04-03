/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm_final_project;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author varsha
 */
public class ALGORITHM_FINAL_PROJECT extends JPanel {

    /**
     * @param args the command line arguments
     */
    public static final int TOTAL_PARTICLES = 35;
    public static final int V_MAX = 10;
    public static final int V_MIN = -15;
    public static final int MAX_ITERATIONS = 1000;
    public static Particle BEST_PARTICLE = new Particle();
    public static ArrayList<Particle> tours = new ArrayList<Particle>();
    public static final int TOTAL_BUILDINGS = 30;
    public static final int flight_time = 75; //in minutes
    public static final double velocity = 100 * 1.609344; //in mph
    public static ArrayList<Buildings> buildingList = new ArrayList<Buildings>();
    public static double inertia = 1.0;
    public static final double TARGET = (velocity * flight_time) / 60;	//(flight time = 25 minutes speed= 80.462kph)			// Number for algorithm to find.
    public static int[] x_coord = new int[]{52, 51, 30, 21, 35, 57, 77, 47, 53, 11, 13, 58, 131, 12, 85, 64, 95, 107,
        75, 35, 87, 115, 59, 18, 17, 25, 34, 24, 64, 97};
    public static int[] y_Coord = new int[]{90, 7, 4, 9, 16, 61, 33, 44, 12, 27, 55, 31, 50, 71, 46, 34, 14, 75, 9, 27,
        71, 27, 113, 45, 16, 57, 99, 85, 49, 99};
    public static final int c1 = 2;
    public static final int c2 = 2;
    public static boolean done = false;
    public static int iteration = 0;
    public static double gBest = 0.0;
    public static JFrame f;

    public ALGORITHM_FINAL_PROJECT() {
        initialize();

    }

    public static void initialize() {

        for (int i = 0; i < ALGORITHM_FINAL_PROJECT.TOTAL_PARTICLES; i++) {
            Particle newParticle = new Particle();
            for (int j = 0; j < TOTAL_BUILDINGS; j++) {
                newParticle.data(j, j);
            }
            ALGORITHM_FINAL_PROJECT.tours.add(newParticle);
            for (int j = 1; j < ALGORITHM_FINAL_PROJECT.TOTAL_PARTICLES; j++) {
                ALGORITHM_FINAL_PROJECT.randomlyArrange(ALGORITHM_FINAL_PROJECT.tours.indexOf(newParticle));
            }
            ALGORITHM_FINAL_PROJECT.getTotalDistance(ALGORITHM_FINAL_PROJECT.tours.indexOf(newParticle));

        }
        minimumGBest();

    }

    /**
     * ****
     * initialize all the tours. Here each particle represents one possible
     * route from source(Disaster management office) to all the buildings in the
     * flood affected area. Constraint is that our source is fixed and we have
     * to visit all the buildings exactly once. Every drone has battery life and
     * thus maximum flight_time. Also ever y drone has maximum velocity.
     * Therefore every drone can cover only certain fixed distance which is
     * calculated using flight_time and maximum velocity of the drone
     */
    public static void listOfBuildings() {
        for (int i = 0; i < TOTAL_BUILDINGS; i++) {
            Buildings building = new Buildings();
            building.x(x_coord[i]);
            building.y(y_Coord[i]);
            buildingList.add(building);
        }
        return;
    }

    public static void main(String[] args) {
        listOfBuildings();
        System.out.println("****TARGET DISTANCE THAT THE DRONE CAN COVER IS***** " + TARGET);
        f = new JFrame();
        ALGORITHM_FINAL_PROJECT p = new ALGORITHM_FINAL_PROJECT();
        f.add(p);
        f.setSize(300, 300);
        f.show();
        p.execute();
    }

    public void execute() {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                boolean val = PSOAlgorithm();

                if (val == true) {
                    repaint();
                    printBestSolution();

                    t.cancel();
                    t.purge();
                }
                repaint();
            }
        }, 100, 500);
    }

    public void paint(Graphics g) {
        int data, data1;
        super.paint(g);
        setBackground(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.drawString("SHORTEST PATH FOR DRONE DELIVERY IN FLOOD AFFECTED AREAS", 215, 15);
        g.drawString("Total distance that the drone can cover before it's battery drains with maximum flight time as 75 minutes and maximum velocity as 100mph is  " + TARGET, 215, 25);
        int k = TOTAL_PARTICLES;
        for (int i = 0; i < k; i++) {
            Particle p = tours.get(i);
            //to highlight gbest in every iteration
            if (BEST_PARTICLE.pBest() != 0) {

                // break;
                for (int j = 0; j < TOTAL_BUILDINGS; j++) {
                    if (BEST_PARTICLE.pBest() <= TARGET) {
                        break;
                    }
                    if (j == TOTAL_BUILDINGS - 1) {
                        data = BEST_PARTICLE.data(j);
                        data1 = BEST_PARTICLE.data(0);
                    } else {
                        data = BEST_PARTICLE.data(j);
                        data1 = BEST_PARTICLE.data(j + 1);
                    }

                    int x1 = buildingList.get(data).x();
                    int y1 = buildingList.get(data).y();
//            System.out.println("***X COordinate is:***" + x1);
//            System.out.println("***Y coordinate is:***" + y1);

                    int x2 = buildingList.get(data1).x();
                    int y2 = buildingList.get(data1).y();
                    g.setColor(Color.GREEN);
                    g.drawString("(" + x1 + "," + y1 + ")", x1 * 5, y1 * 5);
                    g.fillOval(x1 * 5, y1 * 5, 10, 10);
                    g.drawString("(" + x2 + "," + y2 + ")", x2 * 5, y2 * 5);
                    g.fillOval(x2 * 5, y2 * 5, 10, 10);
                    g.setColor(Color.BLUE);
                    g2.setStroke(new BasicStroke(2));
                    g.drawLine(x1 * 5, y1 * 5, x2 * 5, y2 * 5);
                }

            }
            //to highlight the best route 
            if (BEST_PARTICLE.pBest() <= TARGET) {
                //f.getContentPane().removeAll();
                repaint();
                for (int j = 0; j < TOTAL_BUILDINGS; j++) {
                    if (j == TOTAL_BUILDINGS - 1) {
                        data = BEST_PARTICLE.data(j);
                        data1 = BEST_PARTICLE.data(0);
                    } else {
                        data = BEST_PARTICLE.data(j);
                        data1 = BEST_PARTICLE.data(j + 1);
                    }

                    int x1 = buildingList.get(data).x();
                    int y1 = buildingList.get(data).y();
//            System.out.println("***X COordinate is:***" + x1);
//            System.out.println("***Y coordinate is:***" + y1);

                    int x2 = buildingList.get(data1).x();
                    int y2 = buildingList.get(data1).y();
                    g.setColor(Color.GREEN);
                    g.drawString("(" + x1 + "," + y1 + ")", x1 * 5, y1 * 5);
                    //g.setColor(Color.WHITE);

                    g.setColor(Color.GREEN);
                    g.fillOval(x1 * 5, y1 * 5, 10, 10);
                    g.drawString("(" + x2 + "," + y2 + ")", x2 * 5, y2 * 5);
                    g.fillOval(x2 * 5, y2 * 5, 10, 10);

                    g.setColor(Color.RED);
                    g2.setStroke(new BasicStroke(6));
                    g.drawLine(x1 * 5, y1 * 5, x2 * 5, y2 * 5);
                    g.setColor(Color.WHITE);

                }
                g.setColor(Color.WHITE);
                g.drawString("PATH IS:---", 217 * 5, 5 * 5);
                int o1 = 217;
                int o2 = 10;
                for (int t = 0; t < TOTAL_BUILDINGS; t++) {

                    g.drawString("BUILDING: (" + BEST_PARTICLE.data(t) + ")", o1 * 5, o2 * 5);
                    o2 = o2 + 4;
                }

                g.drawString("BUILDING: (0)", o1 * 5, o2 * 5);
                o2 = o2 + 4;
                g.drawString("Total distance to be covered is:--" + BEST_PARTICLE.getWeight(), 210 * 5, o2 * 5);

            }
            //display the network
            for (int j = 0; j < TOTAL_BUILDINGS; j++) {

                if (j == TOTAL_BUILDINGS - 1) {
                    data = p.data(j);
                    data1 = p.data(0);
                } else {
                    data = p.data(j);
                    data1 = p.data(j + 1);
                }

                int x1 = buildingList.get(data).x();
                int y1 = buildingList.get(data).y();
                int x2 = buildingList.get(data1).x();
                int y2 = buildingList.get(data1).y();
                g.setColor(Color.GREEN);
                g.drawString("(" + x1 + "," + y1 + ")", x1 * 5, y1 * 5);
                g.fillOval(x1 * 5, y1 * 5, 10, 10);
                g.drawString("(" + x2 + "," + y2 + ")", x2 * 5, y2 * 5);
                g.fillOval(x2 * 5, y2 * 5, 10, 10);
                g.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(2));
                g.drawLine(x1 * 5, y1 * 5, x2 * 5, y2 * 5);
            }

        }
    }

    //Calculates the euclidean distance between two buildings
    public static double getDistance(final int building1, final int building2) {
        Buildings firstBuilding;
        Buildings secondBuilding;
        double a2 = 0;
        double b2 = 0;
        firstBuilding = buildingList.get(building1);
        secondBuilding = buildingList.get(building2);
        a2 = Math.pow(Math.abs(firstBuilding.x() - secondBuilding.x()), 2);
        b2 = Math.pow(Math.abs(firstBuilding.y() - secondBuilding.y()), 2);

        return Math.sqrt(a2 + b2);
    }

    /**
     * *
     * Main program of PSO. This method updates velocity and location of each
     * particle in every iteration and also finds the pBest of each particle.
     * Every particle is associated with weight which according to original
     * algorithm is our Xid. We update Xid in every iteration depending on the
     * velocity.
     */
    private static boolean PSOAlgorithm() {
        Particle aParticle = null;

        boolean done = false;

        int k = 0;

        // Two conditions can end this loop:
        //    if the maximum number of epochs allowed has been reached, or,
        //    if the Target value has been found.
        if (iteration < MAX_ITERATIONS) {

            for (int i = 0; i < TOTAL_PARTICLES; i++) {
                aParticle = tours.get(i);

                System.out.print("Particle(Route) " + (i + 1) + ":");
                for (int j = 0; j < TOTAL_BUILDINGS; j++) {
                    System.out.print(aParticle.data(j) + ", ");
                }
                System.out.print(aParticle.data(0) + " ");

                System.out.print("Distance: " + aParticle.pBest() + "\n");

                if (aParticle.pBest() <= TARGET || iteration == MAX_ITERATIONS) {
                    done = true;
                }
            }
            gBest = minimumGBest();
            getVelocity();
            updateparticles();

            iteration++;
        } else {
            done = true;
        }

        return done;
    }

    private static double minimumGBest() {

        double gBest = Double.MAX_VALUE;
        for (int i = 0; i < TOTAL_PARTICLES; i++) {
            if (gBest > tours.get(i).mpBest) {
                gBest = tours.get(i).mpBest;
                BEST_PARTICLE = tours.get(i);
            }

        }
        System.out.println();
        System.out.println("****CURRENT GBEST IS:****" + BEST_PARTICLE.pBest());
        return gBest;
    }

    public static void randomlyArrange(final int index) {
        int max = TOTAL_BUILDINGS - 1;
        int b1 = new Random().nextInt(max + 1 - 1) + 1;
        int b2 = 0;
        boolean done = false;
        while (!done) {
            b2 = new Random().nextInt(max + 1 - 1) + 1;
            if (b2 != b1) {
                done = true;
            }
        }

        int temp = tours.get(index).data(b1);
        tours.get(index).data(b1, tours.get(index).data(b2));
        tours.get(index).data(b2, temp);
        return;
    }

    public static double getRandom(double low, double high) {
        Random r = new Random();
        double min = 0.0;
        double max = 0.1;
        double randomNum = r.nextDouble();
        double result = min + (randomNum * (max - min));

        return result;
    }

    private static void getVelocity() {

        double vValue = 0.0;
        double low = 0.0;
        double high = 1.0;
        //inertia = getRandom(0.1, 0.2);
        double r1 = getRandom(low, high);
        double r2 = getRandom(low, high);
        for (int i = 0; i < TOTAL_PARTICLES; i++) {

            vValue = ((inertia * tours.get(i).velocity()) + c1 * r1 * (tours.get(i).pBest() - tours.get(i).getWeight())
                    + c2 * r2 * (gBest - tours.get(i).getWeight()));

            if (vValue > V_MAX) {
                tours.get(i).velocity(V_MAX);
            } else if (vValue < V_MIN) {
                tours.get(i).velocity(V_MIN);
            } else {
                tours.get(i).velocity(vValue);
            }
            System.out.println("***VELOCITY OF PARTICLE " + i + " :" + tours.get(i).velocity());
        }

        return;
    }

    private static void updateparticles() {

        for (int i = 0; i < TOTAL_PARTICLES; i++) {
            tours.get(i).setWeight(tours.get(i).getWeight() + tours.get(i).velocity());

            double changes = tours.get(i).velocity();
            int change = (int) Math.floor(Math.abs(tours.get(i).velocity()));

            for (int j = 0; j < change; j++) {
                if (new Random().nextBoolean()) {
                    randomlyArrange(i);
                }

            }
            //System.out.println("Changes for particle " + i + ": " + changes);

            updatePBest(i);
        }

       
    }

    private static void updatePBest(int index) {

        if (tours.get(index).mpBest > tours.get(index).getWeight()) {
            tours.get(index).pBest(tours.get(index).getWeight());
        }
    }

    private static void printBestSolution() {
        if (BEST_PARTICLE.pBest() <= TARGET) {
            // Print it.
            System.out.println("Target reached.");
        } else {
            System.out.println("Target not reached");
        }
        System.out.print("Shortest Route: ");
        for (int j = 0; j < TOTAL_BUILDINGS; j++) {
            System.out.print(BEST_PARTICLE.data(j) + ", ");
        }
        System.out.print(BEST_PARTICLE.data(0) + "  ");
        System.out.print("Distance: " + BEST_PARTICLE.pBest() + "\n");

    }

    public static void getTotalDistance(final int index) {
        Particle thisParticle = null;
        thisParticle = tours.get(index);
        thisParticle.pBest(0.0);
        thisParticle.setWeight(0.0);

        for (int i = 0; i < TOTAL_BUILDINGS; i++) {
            if (i == TOTAL_BUILDINGS - 1) {
                thisParticle.pBest(thisParticle.pBest() + getDistance(thisParticle.data(TOTAL_BUILDINGS - 1), thisParticle.data(0))); // Complete trip.
                thisParticle.setWeight(thisParticle.getWeight() + getDistance(thisParticle.data(TOTAL_BUILDINGS - 1), thisParticle.data(0)));
            } else {
                thisParticle.pBest(thisParticle.pBest() + getDistance(thisParticle.data(i), thisParticle.data(i + 1)));
                thisParticle.setWeight(thisParticle.getWeight() + getDistance(thisParticle.data(i), thisParticle.data(i + 1)));
            }
        }

    }

}
