/* Copyright by Gokturk Yuksek 2015 */

package hackbu15.pebblechefcompanion;

import android.app.Activity;
import android.content.Context;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.util.ArrayList;
import java.util.UUID;

public final class PebbleConn extends PebbleKit.PebbleDataReceiver {

    private static final UUID uuid = UUID.fromString("07e166bf-5673-477a-a862-94ad7c08e5ed");
    private Activity activity = null;
    ArrayList<IPebbleReceiver> receiverList = new ArrayList<>();

    public PebbleConn(Activity activity) {
        super(uuid);
        this.activity = activity;
        PebbleKit.registerReceivedDataHandler(activity.getApplicationContext(), this);
    }

    public Boolean checkConn() {
        return PebbleKit.isWatchConnected(activity.getApplicationContext());
    }

    public Boolean sendMessage(PebbleMessage message) {
        PebbleDictionary data = new PebbleDictionary();

        if (!checkConn())
            return false;

        data.addUint8(PEBBLE_MSG_KEY.SEQUENCE.ordinal(), message.getSequence());
        data.addString(PEBBLE_MSG_KEY.TITLE.ordinal(), message.getTitle());
        data.addString(PEBBLE_MSG_KEY.DESCRIPTION.ordinal(), message.getDescription());
        data.addString(PEBBLE_MSG_KEY.DURATION.ordinal(), message.getDuration());
        data.addUint8(PEBBLE_MSG_KEY.MORE.ordinal(), message.getMore());

        try {
            PebbleKit.sendDataToPebble(activity.getApplicationContext(), uuid, data);
        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }

    public void setPebbleMessageListener(IPebbleReceiver receiver) {
        receiverList.add(receiver);
    }

    @Override
    public void receiveData(Context context, int i, PebbleDictionary pebbleTuples) {
        System.out.println(pebbleTuples.toJsonString());
        PebbleMessage message = new PebbleMessage();
        long l = pebbleTuples.getUnsignedIntegerAsLong(PEBBLE_MSG_KEY.REQUEST_STEP.ordinal());
        message.setSequence((byte)l);
        for (IPebbleReceiver r : receiverList)
            r.onReceive(message);
        PebbleKit.sendAckToPebble(activity.getApplicationContext(), i);
    }
}
