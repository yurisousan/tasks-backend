package br.ce.wcaquino.taskbackend.utils;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DataUtilsTest {

    @Test
    public void deveRetornarTrueParaDatasFuturas () {
        LocalDate date = LocalDate.of(2030, 01, 01);
        Assert.asserTrue(DateUtils.isEqualOrFutureDate(date));
    }
    @Test
    public void deveRetornarFalseParaDatasFuturas () {
        LocalDate date = LocalDate.of(2010, 01, 01);
        Assert.asserFalse(DateUtils.isEqualOrFutureDate(date));
    }
    @Test
    public void deveRetornarTrueParaDatasAtual () {
        LocalDate date = LocalDate.now();
        Assert.asserTrue(DateUtils.isEqualOrFutureDate(date));
    }
}