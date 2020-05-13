package com.example.coursevisualizer;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private String courseCode;
    private String courseNum;
    private double goalPercentage;
    private ArrayList<CourseComponent> components;

    public Course(String courseName, String courseCode, String courseNum, double goalPercentage) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseNum = courseNum;
        this.goalPercentage = goalPercentage;
        this.components = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public ArrayList<CourseComponent> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<CourseComponent> components) {
        this.components = components;
    }

    public double getGoalPercentage() {
        return goalPercentage;
    }

    public void setGoalPercentage(double goalPercentage) {
        this.goalPercentage = goalPercentage;
    }

    //EFFECTS: produces true if all the course components add up to 100
    public boolean checkValidCourseBreakdown() {
        double sum = 0;
        for (CourseComponent c : components) {
            sum += c.getComponentWeight();
        }
        return Math.round(sum) == 100;
    }

    //REQUIRES: all obtainedWeight for course components except the final have been entered, and the
    //          final exam component is named "Final".
    //EFFECTS: returns the percentage required to obtain on the final to get the desired goal.
    //          returns -1 if current goal is impossible
    public double getRequiredFinalPercentage() {
        double currentPercentage = 0;
        double finalWeight = 0; //must declare value here so java doesn't complain.

        for(CourseComponent c: components) {
            if(c.getComponentName().equals("Final")) {
                finalWeight = c.getComponentWeight();
            } else {
                currentPercentage += c.getObtainedWeight() * c.getComponentWeight();
            }
        }

        if(finalWeight + currentPercentage < goalPercentage) {
            return -1; //goal not obtainable
        }

        double percentNeeded = goalPercentage - currentPercentage;
        return percentNeeded/finalWeight * 100;
    }


    private class CourseComponent {
        private String componentName;
        private double componentWeight;
        private double obtainedWeight;
        //We will assume that if obtainedWeight is empty (i.e it is -1, the component has not yet
        // been completed/graded)
        //obtainedWeight

        public CourseComponent(String componentName, double componentWeight) {
            this.componentName = componentName;
            this.componentWeight = componentWeight;
            this.obtainedWeight = -1;
        }

        public String getComponentName() {
            return componentName;
        }

        public void setComponentName(String componentName) {
            this.componentName = componentName;
        }

        public double getComponentWeight() {
            return componentWeight;
        }

        public void setComponentWeight(double componentWeight) {
            this.componentWeight = componentWeight;
        }

        public double getObtainedWeight() {
            return obtainedWeight;
        }

        public void setObtainedWeight(double obtainedWeight) {
            this.obtainedWeight = obtainedWeight;
        }
    }

}
