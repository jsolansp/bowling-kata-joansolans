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

    @Test
    public void testGutterGame() throws Exception {
        Game g = new Game();
        for (int i=0; i<20; i++)
            g.roll(0);
        assertThat(g.score(),is(0));

    }

    public void testAllOnes() throws Exception {
        Game g = new Game();
        for (int i = 0; i < 20; i++)
            g.roll(1);
        assertThat(g.score(), is(20));
    }

}
