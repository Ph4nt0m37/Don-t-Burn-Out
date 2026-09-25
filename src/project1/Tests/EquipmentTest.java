package project1.Tests;
import project1.Equipment;
import student.TestCase;

public class EquipmentTest extends TestCase
{
    private Equipment equipment;
    
    /**
     * Sets up an Equipment before each test.
     */
    public void setUp()
    {
        equipment = new Equipment(20, "Increases order value");
    }

    
    /**
     * Tests getting the perk value.
     */
    public void testGetValue()
    {
        assertEquals(20, equipment.getValue());
    }
    
    /**
     * Tests getting the perk description.
     */
    public void testGetPerkDescription()
    {
        assertEquals("Increases order value", equipment.getPerkDescription());
    }
}
