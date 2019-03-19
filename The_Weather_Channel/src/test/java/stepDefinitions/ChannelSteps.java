package stepDefinitions;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import cucumber.api.java.pt.Então;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChannelSteps extends Locators{

    public static WebDriver driver;

    @Dado("^que eu esteja no site do Weather Channel")
    public void que_eu_esteja_no_site_do_Weather_Channel(){
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("https://weather.com/pt-BR");
        driver.manage().timeouts().implicitlyWait(50, SECONDS);
        driver.manage().window().maximize();
    }


    @Quando("eu pesquisar pela cidade de Recife")
    public static void eu_pesquisar_pela_cidade_de_Recife() {
        driver.manage().timeouts().implicitlyWait(50, SECONDS);
        driver.findElement(Campo_Busca).sendKeys("Recife");
        driver.findElement(Campo_Busca).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.findElement(Selecionar_Recife).click();

    }

    @Então("o sistema irá exibir a previsão do tempo de Recife")
    public void o_sistema_irá_exibir_a_previsão_do_tempo_de_Recife(){
        WebElement Temperatura_Atual = driver.findElement(By.cssSelector("#hero-left-Nowcard-92c6937d-b8c3-4240-b06c-9da9a8b0d22b > div > div > section > div:nth-child(2) > div > div:nth-child(2) span"));
        System.out.println("Temperatura Atual em Recife: " + Temperatura_Atual.getText());
    }

    @Então("eu clico na opção para a previsão do tempo para cinco dias a frente")
    public void eu_clico_na_opção_para_a_previsão_do_tempo_para_cinco_dias_a_frente(){
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.findElement(Link_5_dias).click();
    }

    @Então("o sistema irá exibir a previsão do tempo para daqui a cinco dias")
    public void o_sistema_irá_exibir_a_previsão_do_tempo_para_daqui_a_cinco_dias() {
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        WebElement Temperatura_Maxima_em_5_dias = driver.findElement(By.cssSelector("#main-DailyForecast-1c4c02b8-a3fd-4069-b54e-93db18c89c1b > div > section > div > table > tbody > tr:nth-child(5) > td.temp div > span:nth-child(3)"));
        WebElement Temperatura_Minima_em_5_dias = driver.findElement(By.cssSelector("#main-DailyForecast-1c4c02b8-a3fd-4069-b54e-93db18c89c1b > div > section > div > table > tbody > tr:nth-child(5) > td.temp div > span:nth-child(1)"));

        System.out.println("Temperatura Mínima em 5 dias: " + Temperatura_Minima_em_5_dias.getText());
        System.out.println("Temperatura Máxima em 5 dias: " + Temperatura_Maxima_em_5_dias.getText());
        System.out.println("########################################");
        System.out.println("Teste Step01 OK");
    }

    @After
    public void quit() {
        driver.quit();
    }



    //CENÁRIO 02
    //##########################################

    @Quando("eu pesquisar pelo mapa da cidade do Recife")
    public static void eu_pesquisar_pelo_mapa_da_cidade_do_Recife() {
        driver.manage().timeouts().implicitlyWait(50, SECONDS);
        driver.findElement(Campo_Busca).sendKeys("Recife");
        driver.findElement(Campo_Busca).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.findElement(Selecionar_Recife).click();
    }

    @Quando("selecionar a opcao de Infravermelho")
    public void selecionar_a_opcao_de_Infravermelho() {
        driver.findElement(Link_Mapa).click();

        driver.manage().timeouts().implicitlyWait(40, SECONDS);
        driver.findElement(Link_Camada_do_Tempo).click();
        driver.manage().timeouts().implicitlyWait(40, SECONDS);
        WebElement popup_Camadas = driver.findElement(By.cssSelector("#hero-left-InteractiveMap-bb45c7ea-e210-4a23-add0-826b6506eaf8 > div > div > div:nth-child(5) > div:nth-child(2) > div.styles__headerBlock__2IyZi"));
        WebDriverWait wait_popup_Camadas = new WebDriverWait(driver, 40);
        wait_popup_Camadas.until(ExpectedConditions.visibilityOf(popup_Camadas));
        System.out.println(popup_Camadas.getText());
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.findElement(Opcao_Infravermelho).click();

    }

    @Então("o sistema ira exibir a camada de infravermelho sobre o mapa")
    public void o_sistema_ira_exibir_a_camada_de_infravermelho_sobre_o_mapa() {
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        WebElement Tela_Infravermelho = driver.findElement(By.cssSelector("#hero-left-InteractiveMap-bb45c7ea-e210-4a23-add0-826b6506eaf8 > div > div > div:nth-child(5) .styles__infoBlock__29NPU .styles__infoTitle__1nskT"));
        assertEquals("Infravermelho", Tela_Infravermelho.getText());

    }


    //CENÁRIO 03
    //##########################################

    @Quando("eu pesquisar pelo mapa de Recife 03")
    public void eu_pesquisar_pelo_mapa_de_Recife_03() {
        driver.manage().timeouts().implicitlyWait(50, SECONDS);
        driver.findElement(Campo_Busca).sendKeys("Recife");
        driver.findElement(Campo_Busca).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.findElement(Selecionar_Recife).click();
    }

    @Quando("selecionar a opcao para rastrear alergias em previsoes especiais")
    public void selecionar_a_opcao_para_rastrear_alergias_em_previsoes_especiais() {
        driver.findElement(link_Mais_Previsoes).click();
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.findElement(Link_Rastrear_Alergias).click();
    }

    @Quando("selecioar a perspectiva diaria de respiracao")
    public void selecioar_a_perspectiva_diaria_de_respiracao() {
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.findElement(Link_Perspectiva_Diaria_Respiracao).click();

    }

    @Entao("o sistema ira exibir as informacoes referentes a Temperatura, Uminade, Precipitacao e Vento.")
    public void o_sistema_ira_exibir_as_informacoes_referentes_a_Temperatura_Uminade_Precipitacao_e_Vento() {
        WebElement Temperatura_Respiracao = driver.findElement(By.cssSelector("#main-LifestyleAllergyOutlook-ceb26d58-14b1-11e7-93ae-92361f002671 > div > section > div > section > div.styles__allergyOutlookContentForecast__10pRi > section > div:nth-child(1) > div:nth-child(1) > span.styles__forecastValue__2PH3E"));
        WebElement Temperatura_Umidade = driver.findElement(By.cssSelector("#main-LifestyleAllergyOutlook-ceb26d58-14b1-11e7-93ae-92361f002671 > div > section > div > section > div.styles__allergyOutlookContentForecast__10pRi > section > div:nth-child(1) > div:nth-child(2) > span.styles__forecastValue__2PH3E"));
        WebElement Temperatura_Precipitacao = driver.findElement(By.cssSelector("#main-LifestyleAllergyOutlook-ceb26d58-14b1-11e7-93ae-92361f002671 > div > section > div > section > div.styles__allergyOutlookContentForecast__10pRi > section > div:nth-child(2) > div:nth-child(1) > span.styles__forecastValue__2PH3E"));
        WebElement Temperatura_Vento = driver.findElement(By.cssSelector("#main-LifestyleAllergyOutlook-ceb26d58-14b1-11e7-93ae-92361f002671 > div > section > div > section > div.styles__allergyOutlookContentForecast__10pRi > section > div:nth-child(2) > div:nth-child(2) > span.styles__forecastValue__2PH3E"));

        System.out.println("Temperatura: " + Temperatura_Respiracao.getText());
        System.out.println("Umidade: " + Temperatura_Umidade.getText());
        System.out.println("Precipitação: " + Temperatura_Precipitacao.getText());
        System.out.println("Vento: " + Temperatura_Vento.getText());

    }

    //######################
    // CENARIO 04

    @Quando("eu pesquisar pelo mapa de Recife 04")
    public void eu_pesquisar_pelo_mapa_de_Recife_04() {
        driver.manage().timeouts().implicitlyWait(50, SECONDS);
        driver.findElement(Campo_Busca).sendKeys("Recife");
        driver.findElement(Campo_Busca).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.findElement(Selecionar_Recife).click();
    }

    @Quando("seleciona a opcao de Mensal")
    public void seleciona_a_opcao_de_Mensal() {
        driver.manage().timeouts().implicitlyWait(50, SECONDS);
        driver.findElement(Menu_Mensal).click();
    }

    @Quando("selecionar a data de um de janeiro de dois mil e dezenove")
    public void selecionar_a_data_de_um_de_janeiro_de_dois_mil_e_dezenove() {
        driver.manage().timeouts().implicitlyWait(50, SECONDS);
        driver.findElement(Calendario).click();
        driver.findElement(Link_Janeiro).click();

    }

    @Entao("o sistema exibe a informacao da temperatura registrada.")
    public void o_sistema_exibe_a_informacao_da_temperatura_registrada() {
        driver.manage().timeouts().implicitlyWait(50, SECONDS);
        driver.findElement(Temperatura_Janeiro).click();
        WebElement Temperatura_Janeiro_2019 = driver.findElement(By.cssSelector("#main-Calendar-21448498-aac6-4a1d-aecc-717f3b4e787b > div > div > span > div.forecast-monthly__day-info.visible > div.forecast-monthly__day-info__content > div.col.col1 > div > div.temp.hi > span"));
        System.out.println("Temperatura em Janeito de 2019: " + Temperatura_Janeiro_2019.getText());
    }

    //CENÁRIO 05
    //####################

    @Quando("eu pesquisar pelo mapa de Recife")
    public void eu_pesquisar_pelo_mapa_de_Recife_05() {
        driver.manage().timeouts().implicitlyWait(50, SECONDS);
        driver.findElement(Campo_Busca).sendKeys("Recife");
        driver.findElement(Campo_Busca).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.findElement(Selecionar_Recife).click();
    }

    @Quando("selecionar a opcao Fim de Semana")
    public void selecionar_a_opcao_Fim_de_Semana() {
        driver.manage().timeouts().implicitlyWait(50, SECONDS);
        driver.findElement(Menu_Fim_de_Semana).click();
    }

    @Quando("selecionar o dia de Sabado da lista de Proximo fim de semana")
    public void selecionar_o_dia_de_Sabado_da_lista_de_Proximo_fim_de_semana() {
        driver.manage().timeouts().implicitlyWait(50, SECONDS);
        driver.findElement(Link_Sabado).click();
    }

    @Entao("o sistema exibe as informacoes Temperatura, Vento, Umidade e Indice UV")
    public void o_sistema_exibe_as_informacoes_Temperatura_Vento_Umidade_e_Indice_UV() {
        WebElement Temperatura_Sabado = driver.findElement(By.cssSelector("#twc-scrollable > section > div > div > div:nth-child(2) > div > section > section:nth-child(1) > div.flex-container > div > div.overview > p.temperature > span"));
        WebElement Vento_Sabado = driver.findElement(By.cssSelector("#twc-scrollable > section > div > div > div:nth-child(2) > div > section > section:nth-child(1) > div.flex-container > div > div.wxdata-table.no-wrap > p > span"));
        WebElement Umidade_Sabado = driver.findElement(By.cssSelector("#twc-scrollable > section > div > div > div:nth-child(2) > div > section > section:nth-child(1) > div.flex-container > div > div.wxdata-table.no-wrap > div.hum-uv-wrap > p.humidity.cell > span > span"));
        WebElement InciceUV_Sabado= driver.findElement(By.cssSelector("#twc-scrollable > section > div > div > div:nth-child(2) > div > section > section:nth-child(1) > div.flex-container > div > div.wxdata-table.no-wrap > div.hum-uv-wrap > p.uv-index.cell > span > span"));

        System.out.println("Temperatura: " + Temperatura_Sabado.getText());
        System.out.println("Vento: " + Vento_Sabado.getText());
        System.out.println("Umidade: " + Umidade_Sabado.getText());
        System.out.println("Índice UV: " + InciceUV_Sabado.getText());
    }

}
