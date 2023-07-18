package com.hcc.entities;
import javax.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {

    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "current_status")
    private String status;

    @Column(name = "current_number", nullable = false)
    private Integer number;

    @Column(name = "current_githubUrl", nullable = false)
    private String githubUrl;

    @Column(name = "current_branch", nullable = false)
    private String branch;

    @Column(name = "current_reviewVideoUrl", nullable = false)
    private String reviewVideoUrl;

    //Many to one relationship with User entity
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    //No args constructor
    public Assignment() {
    }

    //All args constructor for the Assignment entity
    public Assignment(String status, Integer number, String githubUrl, String branch, String reviewVideoUrl, User user) {
        this.status = status;
        this.number = number;
        this.githubUrl = githubUrl;
        this.branch = branch;
        this.reviewVideoUrl = reviewVideoUrl;
        this.user = user;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getReviewVideoUrl() {
        return reviewVideoUrl;
    }

    public void setReviewVideoUrl(String reviewVideoUrl) {
        this.reviewVideoUrl = reviewVideoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
