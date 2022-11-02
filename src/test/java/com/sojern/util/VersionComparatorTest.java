package com.sojern.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionComparatorTest {
    VersionComparator versionComparator;
    @BeforeEach
    void setUp() {
        versionComparator = new VersionComparator();
    }

    @Test
    public void testVersionComparatorEquals() throws Exception {
        assertEquals(versionComparator.compare("1.0", "1.0"),0);
        assertEquals(versionComparator.compare("1.0.00", "1.0"),0);
        assertEquals(versionComparator.compare("1.00.00", "1.0"),0);
    }

    @Test
    public void testVersionComparatorV2GreaterThanV1() throws Exception {
        assertEquals(versionComparator.compare("1234567.0.01.1", "9876543.0.01.1"), -1);
        assertEquals(versionComparator.compare("1.9.9", "2.0"), -1);
        assertEquals(versionComparator.compare("2.2.2.2", "2.3"), -1);
    }

    // First version is greater than the second one
    @Test
    public void testVersionComparatorV1GreaterThanV2() throws Exception {
        assertEquals(versionComparator.compare("1.9.9.2", "1.9.9"), 1);
        assertEquals(versionComparator.compare("1.0", "0.1"),1);

    }
    @Test
    public void testVersionComparatorInvalidScenario() {
        try {
            assertEquals(versionComparator.compare("20.3.8dev", "20.3.8"), 1);
        } catch(NumberFormatException e) {
            assertFalse(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}