package project1.Tests;

import project1.*;
import student.TestCase;

public class EquipmentTest extends TestCase
{
    public void testStove100()
    {
        Equipment equipment = Equipment.STOVE100;

        assertEquals(0, equipment.getValue());
        assertEquals("Stove 100", equipment.getDisplayName());
        assertEquals(
            "Gives you 0% more time to answer questions.",
            equipment.getPerkDescription());
        assertEquals(1.00, equipment.getTimeMult(), 0.001);
        assertEquals("Stove 100", equipment.toString());
    }

    public void testStove250()
    {
        Equipment equipment = Equipment.STOVE250;

        assertEquals(100, equipment.getValue());
        assertEquals("Stove 250", equipment.getDisplayName());
        assertEquals(
            "Gives you 25% more time to answer questions.",
            equipment.getPerkDescription());
        assertEquals(1.25, equipment.getTimeMult(), 0.001);
        assertEquals("Stove 250", equipment.toString());
    }

    public void testStove500()
    {
        Equipment equipment = Equipment.STOVE500;

        assertEquals(250, equipment.getValue());
        assertEquals("Stove 500", equipment.getDisplayName());
        assertEquals(
            "Gives you 50% more time to answer questions.",
            equipment.getPerkDescription());
        assertEquals(1.50, equipment.getTimeMult(), 0.001);
        assertEquals("Stove 500", equipment.toString());
    }

    public void testStove750()
    {
        Equipment equipment = Equipment.STOVE750;

        assertEquals(500, equipment.getValue());
        assertEquals("Stove 750", equipment.getDisplayName());
        assertEquals(
            "Gives you 75% more time to answer questions.",
            equipment.getPerkDescription());
        assertEquals(1.75, equipment.getTimeMult(), 0.001);
        assertEquals("Stove 750", equipment.toString());
    }

    public void testStove1000()
    {
        Equipment equipment = Equipment.STOVE1000;

        assertEquals(750, equipment.getValue());
        assertEquals("Stove 1000", equipment.getDisplayName());
        assertEquals(
            "Gives you 100% more time to answer questions.",
            equipment.getPerkDescription());
        assertEquals(2.00, equipment.getTimeMult(), 0.001);
        assertEquals("Stove 1000", equipment.toString());
    }

    public void testEquipmentOrder()
    {
        assertEquals(4, Equipment.equipmentOrder.size());

        assertEquals(
            Equipment.STOVE250,
            Equipment.equipmentOrder.get(0));

        assertEquals(
            Equipment.STOVE500,
            Equipment.equipmentOrder.get(1));

        assertEquals(
            Equipment.STOVE750,
            Equipment.equipmentOrder.get(2));

        assertEquals(
            Equipment.STOVE1000,
            Equipment.equipmentOrder.get(3));
    }

    public void testEquipmentOrderDoesNotContainStove100()
    {
        assertFalse(
            Equipment.equipmentOrder.contains(Equipment.STOVE100));
    }

    public void testEnumValues()
    {
        Equipment[] values = Equipment.values();

        assertEquals(5, values.length);
        assertEquals(Equipment.STOVE100, values[0]);
        assertEquals(Equipment.STOVE250, values[1]);
        assertEquals(Equipment.STOVE500, values[2]);
        assertEquals(Equipment.STOVE750, values[3]);
        assertEquals(Equipment.STOVE1000, values[4]);
    }

    public void testValueOf()
    {
        assertEquals(
            Equipment.STOVE100,
            Equipment.valueOf("STOVE100"));

        assertEquals(
            Equipment.STOVE250,
            Equipment.valueOf("STOVE250"));

        assertEquals(
            Equipment.STOVE500,
            Equipment.valueOf("STOVE500"));

        assertEquals(
            Equipment.STOVE750,
            Equipment.valueOf("STOVE750"));

        assertEquals(
            Equipment.STOVE1000,
            Equipment.valueOf("STOVE1000"));
    }
}