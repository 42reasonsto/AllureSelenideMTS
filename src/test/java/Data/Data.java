package Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@AllArgsConstructor
@Getter
public class Data {
    private String date;

    private String mail;

    private String fullName;

    private String term;

    private String sum;

    private String initialFee;

    private String region;

    private String countExternalTransfer;

    private String cashDeposit;

    private String cashWithdrawal;

    private String creditingMoney;

    private String nameOrganization;

    private String organizationForm;
}
