package com.manohar.root.geoquiz;

/**
 * Created by root on 5/12/17.
 */

public class Question {
    private   int qid;
    private  boolean ans;
    Question(int qid,boolean ans)
    {
        this.qid=qid;
        this.ans=ans;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public boolean getAns() {
        return ans;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }
}
