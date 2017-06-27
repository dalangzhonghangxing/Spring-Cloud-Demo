package org.test.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "t_record")
@Entity
public class Record extends BaseEntity {

    private static final long serialVersionUID = 4032938940375750059L;

    @Column
    private Account tester;

    @Column
    private Test test;

    @Column
    private int score;

    public Account getTester() {
        return tester;
    }

    public void setTester(Account tester) {
        this.tester = tester;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
