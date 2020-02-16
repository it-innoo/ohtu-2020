package ohtu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ohtu.verkkokauppa.*;

public class Main {

    private static ApplicationContext ctx;

    public static void main(final String[] args) {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        final Kauppa kauppa = ctx.getBean(Kauppa.class);
        // Kirjanpito kirjanpito = new Kirjanpito();

        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        final IKirjanpito kirjanpito = ctx.getBean(Kirjanpito.class);
        for (final String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }

    }
}
