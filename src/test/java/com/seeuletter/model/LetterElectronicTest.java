package com.seeuletter.model;

import com.seeuletter.BaseTest;
import com.seeuletter.net.SeeuletterResponse;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class LetterElectronicTest extends BaseTest {

    @Test
    public void testListLetterElectronicWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("channel", "electronic");

        SeeuletterResponse<LetterCollection> response = LetterElectronic.list(params);


}

