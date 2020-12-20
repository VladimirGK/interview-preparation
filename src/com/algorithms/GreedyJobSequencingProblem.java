package com.algorithms;

import java.util.ArrayList;

public class GreedyJobSequencingProblem {
    static class Job {
        private String id;
        private int deadline, profit;

        public Job(String id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        public String toString() {
            return profit + " ";
        }
    }

    public void printJobScheduling(ArrayList<Job> jobs, int t) {
        int n = jobs.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (jobs.get(j).profit < jobs.get(j + 1).profit) {
                    Job temp = jobs.get(j);
                    jobs.set(j, jobs.get(j + 1));
                    jobs.set(j + 1, temp);
                }
            }
        }
        boolean[] result = new boolean[t];
        String[] job = new String[t];
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(t - 1, jobs.get(i).deadline - 1); j >= 0; j--) {
                if (!result[j]) {
                    result[j] = true;
                    job[j] = jobs.get(i).id;
                    break;
                }
            }
        }
        for (String jb : job) {
            System.out.println(jb + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Junior", 2, 100));
        jobs.add(new Job("Senior", 2, 52));
        jobs.add(new Job("TechLead", 4, 52));
        GreedyJobSequencingProblem jsp = new GreedyJobSequencingProblem();
        jsp.printJobScheduling(jobs, 2);
    }
}
