package ru.kireev.abstractfactory;

import ru.otus.abstractfactory.led.LedFactory;
import ru.otus.abstractfactory.luminescent.LuminescentFactory;

/**
 * @author sergey
 * created on 17.09.18.
 */
public class Demo {

  private Demo(AbstractFactory abstractFactory) {
    Bulb bulb = abstractFactory.createBulb();
    Lampholder lampholder = abstractFactory.createLampholder();

    bulb.light();
    lampholder.hold();
  }

  public static AbstractFactory configuration(String param) {
    if ("Led".equals(param)) {
      return new LedFactory();
    }
    if ("Luminescent".equals(param)) {
      return new LuminescentFactory();
    }
    throw new IllegalArgumentException("unknown param:" + param);
  }

  public static void main(String[] args) {
    new Demo(configuration("Led"));
    new Demo(configuration("Luminescent"));
  }

}
