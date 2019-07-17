package com.cxb.drapp.pojo;

public class Doctor {
    private String did;
    private String name;
    private String hospital;

    private String departments;

    private String title;

    private String d_info;

    @Override
    public String toString() {
        return "Doctor{" +
                "did='" + did + '\'' +
                ", dname='" + name + '\'' +
                ", hospital='" + hospital + '\'' +
                ", departments='" + departments + '\'' +
                ", title='" + title + '\'' +
                ", d_info='" + d_info + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments == null ? null : departments.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getD_info() {
        return d_info;
    }

    public void setD_info(String d_info) {
        this.d_info = d_info == null ? null : d_info.trim();
    }
}