package org.im97mori.ble.service.bms.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.BOND_MANAGEMENT_SERVICE;

import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.ServiceData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Bond Management Service data class
 */
public class BondManagementServiceData extends ServiceData {

    /**
     * @see Creator
     */
    public static final Creator<BondManagementServiceData> CREATOR = new Creator<BondManagementServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public BondManagementServiceData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new BondManagementServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BondManagementServiceData[] newArray(int size) {
            return new BondManagementServiceData[size];
        }

    };

    /**
     * Bond Management Feature data
     */
    @SerializedName("bond_management_feature")
    public CharacteristicData bondManagementFeature;

    /**
     * Bond Management Control Point data
     */
    @SerializedName("bond_management_control_point")
    public BondManagementControlPointCharacteristicData bondManagementControlPoint;

    /**
     * Constructor
     */
    public BondManagementServiceData() {
    }

    /**
     * @param bondManagementFeature      Bond Management Feature data
     * @param bondManagementControlPoint Bond Management Control Point data
     */
    public BondManagementServiceData(@NonNull CharacteristicData bondManagementFeature
            , @NonNull BondManagementControlPointCharacteristicData bondManagementControlPoint) {
        super(BOND_MANAGEMENT_SERVICE
                , BluetoothGattService.SERVICE_TYPE_PRIMARY
                , Collections.emptyList());
        this.bondManagementFeature = bondManagementFeature;
        this.bondManagementControlPoint = bondManagementControlPoint;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public BondManagementServiceData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bondManagementFeature = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
            bondManagementControlPoint = in.readParcelable(this.getClass().getClassLoader(), BondManagementControlPointCharacteristicData.class);
        } else {
            bondManagementFeature = in.readParcelable(this.getClass().getClassLoader());
            bondManagementControlPoint = in.readParcelable(this.getClass().getClassLoader());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacteristicData> getCharacteristicDataList() {
        return Arrays.asList(bondManagementFeature
                , bondManagementControlPoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(bondManagementFeature, flags);
        dest.writeParcelable(bondManagementControlPoint, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(bondManagementFeature)
                ^ Objects.hashCode(bondManagementControlPoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ServiceData) {
            BondManagementServiceData target = (BondManagementServiceData) obj;
            result = super.equals(target)
                    && Objects.equals(bondManagementFeature, target.bondManagementFeature)
                    && Objects.equals(bondManagementControlPoint, target.bondManagementControlPoint);
        }
        return result;
    }
}
