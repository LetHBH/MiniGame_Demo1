package com.lhbh.view;

import com.lhbh.service.ScoreRecorder;

import javax.swing.*;
import java.awt.*;

public class ScoreDialog extends JDialog {
    super(frame,true);
    int scores[] = ScoreRecorder.getScores();
    JPanel scoreP = new JPanel(new GridLayout(4,1));
    scoreP.setBackground(Color.WHITE);
}
