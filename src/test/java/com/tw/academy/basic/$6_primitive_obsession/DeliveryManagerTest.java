package com.tw.academy.basic.$6_primitive_obsession;
import com.tw.academy.basic.$6_primitive_obsession.practiceOne.DeliverCenter;
import com.tw.academy.basic.$6_primitive_obsession.practiceOne.DeliveryManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryManagerTest {
    @Test
    public void should_allocate_to_local_when_target_address_same_with_mailing_address() {
        String mailingAddress = "Hubei Province Wuhan City Jianghan District Jiefang Street No. 1277";
        String targetAddress = "Hubei Province Wuhan City Qiaokou District Jiefang Street No. 1095";
        DeliveryManager deliveryManager = new DeliveryManager(mailingAddress, targetAddress);

        DeliverCenter actual = deliveryManager.allocate();

        assertEquals(DeliverCenter.LOCAL, actual);
    }

    @Test
    public void should_allocate_to_province_when_target_address_and_mailing_address_in_same_province() {
        String mailingAddress = "Hubei Province Wuhan City Jianghan District Jiefang Street No. 1277";
        String targetAddress = "Hubei Province Shiyan City Danjiangkou City Taihe Street Yongle Street No. 13";
        DeliveryManager deliveryManager = new DeliveryManager(mailingAddress, targetAddress);

        DeliverCenter actual = deliveryManager.allocate();

        assertEquals(DeliverCenter.PROVINCE, actual);
    }

    @Test
    public void should_allocate_to_foreign_when_target_address_and_mailing_address_in_different_province() {
        String mailingAddress = "Sichuan Province Chengdu City Wuhou District Guoxue Street No. 37";
        String targetAddress = "Hubei Province Wuhan City Jianghan District Jiefang Street No. 1277";
        DeliveryManager deliveryManager = new DeliveryManager(mailingAddress, targetAddress);

        DeliverCenter actual = deliveryManager.allocate();

        assertEquals(DeliverCenter.FOREIGN, actual);
    }
}
