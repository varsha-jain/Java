/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm_final_project;

/**
 *
 * @author varsha
 */
public class Particle {

  private int mData[] = new int[ALGORITHM_FINAL_PROJECT.TOTAL_BUILDINGS];
        public double mpBest = 0;
        public double mVelocity = 0.0;
        public double weight = 0.0;
       

        public Particle() {
            this.mpBest = 0;
            this.mVelocity = 0.0;
            this.weight = 0.0;
        }       

        public int data(final int index) {
            return this.mData[index];
        }

        public void data(final int index, final int value) {
            this.mData[index] = value;
            return;
        }
        
        public double pBest() {
            return this.mpBest;
        }

        public void pBest(final double value) {
            this.mpBest = value;
            return;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double velocity() {
            return this.mVelocity;
        }

        public void velocity(final double velocityScore) {
            this.mVelocity = velocityScore;
            return;
        }

}