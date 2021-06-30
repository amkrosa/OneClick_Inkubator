import Helpers.Enums.Dictionaries.ClientDictionary;
import Helpers.Enums.Types.DeliveryMethod;
import Helpers.Enums.Dictionaries.InvoiceDictionary;
import Helpers.Navigate;
import Models.Client;
import Models.Invoice;
import Pages.FormPage;
import Pages.SummaryPage;
import SeleniumBase.Base;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SummaryTest {

    private final Client receiverPm = ClientDictionary.BOXMACHINE.client;
    private final Client sender = ClientDictionary.SENDER.client;
    private final Client receiverAddress = ClientDictionary.ADDRESS.client;

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class SummaryBoxmachineText extends Base {

        @Test
        @Order(1)
        public void Should_DisplayModalSummary_When_FormFilledWithCorrectData_And_SubmitIsClicked() {
            page.ModalSummary.setDeliveryMethod(DeliveryMethod.BOXMACHINE);
            Navigate.FillFormPage(DeliveryMethod.BOXMACHINE, receiverPm, sender);
            assertTrue(page.Form.submit(), "Modal was not displayed.");
        }

        @Test
        @Order(2)
        public void Should_DisplayCorrectDataInModalSummary_When_FilledWithCorrectDataBoxmachineDeliveryType() {
            Navigate.FillFormPage(DeliveryMethod.BOXMACHINE, receiverPm, sender);
            page.Form.submit();
            page.ModalSummary.setDeliveryMethod(DeliveryMethod.BOXMACHINE);
            page.ModalSummary.setReceiverParcelmachineFields();
            assertAll(() -> assertEquals(receiverPm.getName(), page.ModalSummary.receiverName().text()),
                    () -> assertEquals(receiverPm.getPhone(), page.ModalSummary.receiverPhone().text().replace(" ", "")),
                    () -> assertEquals(receiverPm.getEmail(), page.ModalSummary.receiverEmail().text()),
                    () -> assertEquals(receiverPm.getParcelmachine(), page.ModalSummary.receiverParcelmachineName().text())
            );
        }
        @Test
        @Order(3)
        public void Should_DisplayCorrectSenderDataInModalSummary_When_FilledWithCorrectDataBoxmachineDeliveryType() {
            assertAll(
                    () -> assertEquals(sender.getName(), page.ModalSummary.senderName().text()),
                    () -> assertEquals(sender.getPhone(), page.ModalSummary.senderPhone().text().replace(" ", "")),
                    () -> assertEquals(sender.getEmail(), page.ModalSummary.senderEmail().text())
            );
        }

        @Test
        @Order(4)
        public void Should_DisplayCorrectReceiverDataInFinalSummary_When_FilledWithCorrectDataBoxmachineDeliveryType() {
            page.FinalSummary.setDeliveryMethod(DeliveryMethod.BOXMACHINE);
            Navigate.FromModalSummaryToFinalSummary(page.FinalSummary);
            page.FinalSummary.setReceiverParcelmachineFields();
            assertAll(() -> assertEquals(receiverPm.getName(), page.FinalSummary.receiverName().text()),
                    () -> assertEquals(receiverPm.getPhone(), page.FinalSummary.receiverPhone().text().replace(" ", "")),
                    () -> assertEquals(receiverPm.getEmail(), page.FinalSummary.receiverEmail().text()),
                    () -> assertEquals(receiverPm.getParcelmachine(), page.FinalSummary.receiverParcelmachineName().text())
            );
        }
        @Test
        @Order(5)
        public void Should_DisplayCorrectSenderDataInFinalSummary_When_FilledWithCorrectDataBoxmachineDeliveryType() {
            assertAll(
                    () -> assertEquals(sender.getName(), page.FinalSummary.senderName().text()),
                    () -> assertEquals(sender.getPhone(), page.FinalSummary.senderPhone().text().replace(" ", "")),
                    () -> assertEquals(sender.getEmail(), page.FinalSummary.senderEmail().text())
            );
        }
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class SummaryAddressTest extends Base {

        @Test
        @Order(1)
        public void Should_DisplayModalSummary_When_FormFilledWithCorrectData_And_SubmitIsClicked() {
            page.ModalSummary.setDeliveryMethod(DeliveryMethod.ADDRESS);
            Navigate.FillFormPage(DeliveryMethod.ADDRESS, receiverAddress, sender);
            assertTrue(page.Form.submit(), "Modal was not displayed.");
        }
        @Test
        @Order(1)
        public void Should_DisplayCorrectReceiverDataInModalSummary_When_Submitted() {
            assertAll(() -> assertEquals(receiverAddress.getName(), page.ModalSummary.receiverName().text()),
                    ()->  assertEquals(receiverAddress.getPhone(), page.ModalSummary.receiverPhone().text().replace(" ", "")),
                    ()->  assertEquals(receiverAddress.getEmail(), page.ModalSummary.receiverEmail().text()),
                    ()->  assertEquals(receiverAddress.getZipCode()+" "+receiverAddress.getCity(), page.ModalSummary.receiverZipCodeCity().text()),
                    ()->  assertEquals(receiverAddress.getStreet()+" "+receiverAddress.getBuildingNo()+"/"+receiverAddress.getFlatNo(), page.ModalSummary.receiverStreetBuildingNo().text())
            );
        }

        @Test
        @Order(2)
        public void Should_DisplayCorrectSenderDataInModalSummary_When_Submitted() {
            assertAll(
                    () -> assertEquals(sender.getName(), page.ModalSummary.senderName().text()),
                    () -> assertEquals(sender.getPhone(), page.ModalSummary.senderPhone().text().replace(" ", "")),
                    () -> assertEquals(sender.getEmail(), page.ModalSummary.senderEmail().text())
            );
        }

        @Test
        @Order(3)
        public void Should_DisplayCorrectReceiverDataInFinalSummary_When_FilledWithCorrectDataAddressDeliveryType() {
            page.FinalSummary.setDeliveryMethod(DeliveryMethod.ADDRESS);

            Navigate.FromModalSummaryToFinalSummary(page.FinalSummary);
            assertAll(() -> assertEquals(receiverAddress.getName(), page.FinalSummary.receiverName().text()),
                    ()->  assertEquals(receiverAddress.getPhone(), page.FinalSummary.receiverPhone().text().replace(" ", "")),
                    ()->  assertEquals(receiverAddress.getEmail(), page.FinalSummary.receiverEmail().text()),
                    ()->  assertEquals(receiverAddress.getZipCode()+" "+receiverAddress.getCity(), page.FinalSummary.receiverZipCodeCity().text()),
                    ()->  assertEquals(receiverAddress.getStreet()+" "+receiverAddress.getBuildingNo()+"/"+receiverAddress.getFlatNo(), page.FinalSummary.receiverStreetBuildingNo().text())
            );
        }

        @Test
        @Order(4)
        public void Should_DisplayCorrectSenderDataInFinalSummary_When_FilledWithCorrectDataAddressDeliveryType() {
            assertAll(
                    () -> assertEquals(sender.getName(), page.FinalSummary.senderName().text()),
                    () -> assertEquals(sender.getPhone(), page.FinalSummary.senderPhone().text().replace(" ", "")),
                    () -> assertEquals(sender.getEmail(), page.FinalSummary.senderEmail().text())
            );
        }
    }


}
