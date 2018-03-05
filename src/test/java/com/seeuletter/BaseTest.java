package com.seeuletter;

import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void beforeClass() {
        Seeuletter.init("test_9de14732-7726-41c3-8e5f-daf071d2756a");
    }

}
