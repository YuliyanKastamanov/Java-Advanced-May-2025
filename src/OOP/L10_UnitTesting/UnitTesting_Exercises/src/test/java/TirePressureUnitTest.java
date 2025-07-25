import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

public class TirePressureUnitTest {


    @Test
    public void whenTyrePressureIsLessThan17_thenAlarmIsOn(){

        //Не искам да имам реален сензор
        //Искам да имам обект, на който аз да му казвам как да се държи
        //мокнат обект, който лесно мога да манипулирам

        //Sensor sensor = new Sensor();
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.00);

        alarm.check();

        Assertions.assertTrue(alarm.getAlarmOn());

    }

    @Test
    public void whenTyrePressureIsMoreThan21_thenAlarmIsOn(){

        //Не искам да имам реален сензор
        //Искам да имам обект, на който аз да му казвам как да се държи
        //мокнат обект, който лесно мога да манипулирам

        //Sensor sensor = new Sensor();
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.00);

        alarm.check();

        Assertions.assertTrue(alarm.getAlarmOn());

    }

    @Test
    public void whenTyrePressureIsBetween17And21_thenAlarmIsOff(){

        //Не искам да имам реален сензор
        //Искам да имам обект, на който аз да му казвам как да се държи
        //мокнат обект, който лесно мога да манипулирам

        //Sensor sensor = new Sensor();
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.00);

        alarm.check();

        Assertions.assertFalse(alarm.getAlarmOn());

    }



    @Test
    public void whenPopNextPressurePsiValue_thenReceivedMockedValue(){

        // метода spy() ни дава реален сензор, но можем да override-нем някои методи
        Sensor sensor = Mockito.spy(new Sensor());

        // Принуждаваме popNextPressurePsiValue() да върне фиксирана стойност
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.5);


        // Тестваме реалния метод popNextPressurePsiValue()
        double result = sensor.popNextPressurePsiValue();

        // 16 (OFFSET) + 2.5 = 18.5
        Assertions.assertEquals(18.5, result);


    }


}
