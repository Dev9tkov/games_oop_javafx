package job4j.tictactoe;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class Logic3TTest {

    @Test
    public void whenHasXHorizontalWinner() {
        Figure3T[][] tablemid = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(true, false), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Figure3T[][] tablehigh = {
                {new Figure3T(true, false), new Figure3T(true, false), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Figure3T[][] tablelow = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(true, false), new Figure3T(true, false)},
        };
        Logic3T loginm = new Logic3T(tablemid);
        Logic3T loginh = new Logic3T(tablehigh);
        Logic3T loginl = new Logic3T(tablelow);
        assertThat(loginm.isWinnerX() && loginh.isWinnerX() && loginl.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXDiagonaWinner() {
        Figure3T[][] tableleft = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        Figure3T[][] tableright = {
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
        };
        Logic3T loginl = new Logic3T(tableleft);
        Logic3T loginr = new Logic3T(tableright);
        assertThat(loginl.isWinnerX() && loginr.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXVerticalWinner() {
        Figure3T[][] tablemid = {
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
        };
        Figure3T[][] tableleft = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
        };
        Figure3T[][] tableright = {
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T loginm = new Logic3T(tablemid);
        Logic3T loginl = new Logic3T(tableleft);
        Logic3T loginr = new Logic3T(tableright);
        assertThat(loginm.isWinnerX() && loginl.isWinnerX() && loginr.isWinnerX(), is(true));
    }

    @Test
    public void whenHasOHorizontalWinner() {
        Figure3T[][] tablemid = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(false, true), new Figure3T(false, true)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Figure3T[][] tablehigh = {
                {new Figure3T(false, true), new Figure3T(false, true), new Figure3T(false, true)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Figure3T[][] tablelow = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(false, true), new Figure3T(false, true)},
        };
        Logic3T loginm = new Logic3T(tablemid);
        Logic3T loginh = new Logic3T(tablehigh);
        Logic3T loginl = new Logic3T(tablelow);
        assertThat(loginm.isWinnerO() && loginh.isWinnerO() && loginl.isWinnerO(), is(true));
    }

    @Test
    public void whenNotFill() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(false));
    }

    @Test
    public void whenHasGap() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }
}
