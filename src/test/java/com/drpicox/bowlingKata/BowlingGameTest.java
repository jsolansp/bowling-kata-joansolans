package com.drpicox.bowlingKata;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class BowlingGameTest extends TestCase {
    private Game g;

    protected void setUp() throws Exception {
        g = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++)
            g.roll(pins);
    }

    @Test
    public void testGutterGame() throws Exception {
        rollMany(20, 0);
        assertThat(g.score(),is(0));
    }

    public void testAllOnes() throws Exception {
        rollMany(20,1);
        assertThat(g.score(), is(20));
    }

    public void testOneSpare() throws Exception {
        rollSpare();
        g.roll(3);
        rollMany(17,0);
        assertEquals(16,g.score());
    }

    public void testOneStrike() throws Exception {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    public void testPerfectGame() throws Exception {
        rollMany(12,10);
        assertEquals(300, g.score());
    }

    private void rollStrike() {
        g.roll(10);
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }
}
