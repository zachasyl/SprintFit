import static org.junit.Assert.assertEquals;

public class DAOTest {
    public DAO daoOne;

    /**
     * Tests that .getExercise will return the correct exercise object
     * and .getCalories will return the calories burned for that object.
     */
    @org.junit.Test
    public void testGetExercise() {
        daoOne = new DAO();
        int daoTest = DAO.getExercise(8).getCalories();
        assertEquals(52,daoTest);
    }
}