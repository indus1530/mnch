package edu.aku.abdulsajid.uenMnch.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import edu.aku.abdulsajid.uenMnch.R;
import edu.aku.abdulsajid.uenMnch.RMOperations.crudOperations;
import edu.aku.abdulsajid.uenMnch.core.MainApp;
import edu.aku.abdulsajid.uenMnch.data.DAO.FormsDAO;
import edu.aku.abdulsajid.uenMnch.databinding.ActivityQoc1Binding;

import static edu.aku.abdulsajid.uenMnch.activities.LoginActivity.db;
import static edu.aku.abdulsajid.uenMnch.activities.RSDInfoActivity.fc;


public class Qoc1 extends AppCompatActivity {

    ActivityQoc1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc1);
        bi.setCallback(this);
        this.setTitle(getString(R.string.routinetwo) + "(" + fc.getReportingMonth() + ")");

    }


    public void BtnContinue() {
        if (!formValidation()) return;
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                MainApp.endActivity(this, this, Qoc2.class, true, RSDInfoActivity.fc);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, RSDInfoActivity.fc);
    }

    private boolean UpdateDB() {
        try {
            Long longID = new crudOperations(db, RSDInfoActivity.fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.llqoc1);
    }

    private void SaveDraft() throws JSONException {

        JSONObject qoc1 = new JSONObject();

        qoc1.put("qa0101a", bi.qa0101aa.isChecked() ? "1"
                : bi.qa0101ab.isChecked() ? "2"
                : bi.qa0101a97.isChecked() ? "NA"
                : "-1");
        qoc1.put("qa0101b", bi.qa0101b.getText().toString().trim().isEmpty() ? "-1" : bi.qa0101b.getText().toString());
//        qoc1.put("qa0101c", bi.qa0101c.getText().toString().trim().length() > 0 ? bi.qa0101c.getText().toString() : "0");

        qoc1.put("qa0102a", bi.qa0102aa.isChecked() ? "1"
                : bi.qa0102ab.isChecked() ? "2"
                : bi.qa0102a97.isChecked() ? "NA"
                : "-1");
        qoc1.put("qa0102b", bi.qa0102b.getText().toString().trim().isEmpty() ? "-1" : bi.qa0102b.getText().toString());
//        qoc1.put("qa0102c", bi.qa0102c.getText().toString().trim().length() > 0 ? bi.qa0102c.getText().toString() : "0");

        qoc1.put("qa0103a", bi.qa0103aa.isChecked() ? "1"
                : bi.qa0103ab.isChecked() ? "2"
                : bi.qa0103a97.isChecked() ? "NA"
                : "-1");
        qoc1.put("qa0103b", bi.qa0103b.getText().toString().trim().isEmpty() ? "-1" : bi.qa0103b.getText().toString());
//        qoc1.put("qa0103c", bi.qa0103c.getText().toString().trim().length() > 0 ? bi.qa0103c.getText().toString() : "0");

        qoc1.put("qa0104a", bi.qa0104aa.isChecked() ? "1"
                : bi.qa0104ab.isChecked() ? "2"
                : bi.qa0104a97.isChecked() ? "NA"
                : "-1");
        qoc1.put("qa0104b", bi.qa0104b.getText().toString().trim().isEmpty() ? "-1" : bi.qa0104b.getText().toString());
//        qoc1.put("qa0104c", bi.qa0104c.getText().toString().trim().length() > 0 ? bi.qa0104c.getText().toString() : "0");

        qoc1.put("qa0105a", bi.qa0105aa.isChecked() ? "1"
                : bi.qa0105ab.isChecked() ? "2"
                : bi.qa0105a97.isChecked() ? "NA"
                : "-1");
        qoc1.put("qa0105b", bi.qa0105b.getText().toString().trim().isEmpty() ? "-1" : bi.qa0105b.getText().toString());
//        qoc1.put("qa0105c", bi.qa0105c.getText().toString().trim().length() > 0 ? bi.qa0105c.getText().toString() : "0");

        qoc1.put("qa0106a", bi.qa0106aa.isChecked() ? "1"
                : bi.qa0106ab.isChecked() ? "2"
                : bi.qa0106a97.isChecked() ? "NA"
                : "-1");
        qoc1.put("qa0106b", bi.qa0106b.getText().toString().trim().isEmpty() ? "-1" : bi.qa0106b.getText().toString());
//        qoc1.put("qa0106c", bi.qa0106c.getText().toString().trim().length() > 0 ? bi.qa0106c.getText().toString() : "0");

        qoc1.put("qa0107a", bi.qa0107aa.isChecked() ? "1"
                : bi.qa0107ab.isChecked() ? "2"
                : bi.qa0107a97.isChecked() ? "NA"
                : "-1");
        qoc1.put("qa0107b", bi.qa0107b.getText().toString().trim().isEmpty() ? "-1" : bi.qa0107b.getText().toString());
//        qoc1.put("qa0107c", bi.qa0107c.getText().toString().trim().length() > 0 ? bi.qa0107c.getText().toString() : "0");

        qoc1.put("qa0108a", bi.qa0108aa.isChecked() ? "1"
                : bi.qa0108ab.isChecked() ? "2"
                : bi.qa0108a97.isChecked() ? "NA"
                : "-1");
        qoc1.put("qa0108b", bi.qa0108b.getText().toString().trim().isEmpty() ? "-1" : bi.qa0108b.getText().toString());
//        qoc1.put("qa0108c", bi.qa0108c.getText().toString().trim().length() > 0 ? bi.qa0108c.getText().toString() : "0");

        qoc1.put("qa0109a", bi.qa0109aa.isChecked() ? "1"
                : bi.qa0109ab.isChecked() ? "2"
                : bi.qa0109a97.isChecked() ? "NA"
                : "-1");
        qoc1.put("qa0109b", bi.qa0109b.getText().toString().trim().isEmpty() ? "-1" : bi.qa0109b.getText().toString());
//        qoc1.put("qa0109c", bi.qa0109c.getText().toString().trim().length() > 0 ? bi.qa0109c.getText().toString() : "0");

        qoc1.put("qa0110a", bi.qa0110aa.isChecked() ? "1"
                : bi.qa0110ab.isChecked() ? "2"
                : bi.qa0110a97.isChecked() ? "NA"
                : "-1");
        qoc1.put("qa0110b", bi.qa0110b.getText().toString().trim().isEmpty() ? "-1" : bi.qa0110b.getText().toString());
//        qoc1.put("qa0110c", bi.qa0110c.getText().toString().trim().length() > 0 ? bi.qa0110c.getText().toString() : "0");

        qoc1.put("qa0111a", bi.qa0111aa.isChecked() ? "1"
                : bi.qa0111ab.isChecked() ? "2"
                : bi.qa0111a97.isChecked() ? "NA"
                : "-1");
        qoc1.put("qa0111b", bi.qa0111b.getText().toString().trim().isEmpty() ? "-1" : bi.qa0111b.getText().toString());
//        qoc1.put("qa0111c", bi.qa0111c.getText().toString().trim().length() > 0 ? bi.qa0111c.getText().toString() : "0");

        qoc1.put("qa0112a", bi.qa0112aa.isChecked() ? "1" : bi.qa0112ab.isChecked() ? "2" : bi.qa0112a97.isChecked() ? "NA" : "0");
        qoc1.put("qa0112b", bi.qa0112b.getText().toString().trim().length() > 0 ? bi.qa0112b.getText().toString() : "0");
//        qoc1.put("qa0112c", bi.qa0112c.getText().toString().trim().length() > 0 ? bi.qa0112c.getText().toString() : "0");

        qoc1.put("qa0113a", bi.qa0113aa.isChecked() ? "1" : bi.qa0113ab.isChecked() ? "2" : bi.qa0113a97.isChecked() ? "NA" : "0");
        qoc1.put("qa0113b", bi.qa0113b.getText().toString().trim().length() > 0 ? bi.qa0113b.getText().toString() : "0");
//        qoc1.put("qa0113c", bi.qa0113c.getText().toString().trim().length() > 0 ? bi.qa0113c.getText().toString() : "0");

        qoc1.put("qa0114a", bi.qa0114aa.isChecked() ? "1" : bi.qa0114ab.isChecked() ? "2" : bi.qa0114a97.isChecked() ? "NA" : "0");
        qoc1.put("qa0114b", bi.qa0114b.getText().toString().trim().length() > 0 ? bi.qa0114b.getText().toString() : "0");
//        qoc1.put("qa0114c", bi.qa0114c.getText().toString().trim().length() > 0 ? bi.qa0114c.getText().toString() : "0");

        qoc1.put("qa0115a", bi.qa0115aa.isChecked() ? "1" : bi.qa0115ab.isChecked() ? "2" : bi.qa0115a97.isChecked() ? "NA" : "0");
        qoc1.put("qa0115b", bi.qa0115b.getText().toString().trim().length() > 0 ? bi.qa0115b.getText().toString() : "0");
//        qoc1.put("qa0115c", bi.qa0115c.getText().toString().trim().length() > 0 ? bi.qa0115c.getText().toString() : "0");

        qoc1.put("qa0116a", bi.qa0116aa.isChecked() ? "1" : bi.qa0116ab.isChecked() ? "2" : bi.qa0116a97.isChecked() ? "NA" : "0");
        qoc1.put("qa0116b", bi.qa0116b.getText().toString().trim().length() > 0 ? bi.qa0116b.getText().toString() : "0");
//        qoc1.put("qa0116c", bi.qa0116c.getText().toString().trim().length() > 0 ? bi.qa0116c.getText().toString() : "0");

        qoc1.put("qa01Ap", bi.qa01AP.getText().toString().trim().length() > 0 ? bi.qa01AP.getText().toString() : "0");

        fc.setSA(String.valueOf(qoc1));

    }

}
