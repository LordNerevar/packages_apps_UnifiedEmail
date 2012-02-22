/**
 * Copyright (c) 2012, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.mail.providers;

import android.content.Intent;
import android.os.Parcel;
import android.test.AndroidTestCase;

import com.android.mail.utils.Utils;

public class AccountTests extends AndroidTestCase {

    public void testSerializeDeSerialize() {
        Parcel dest = Parcel.obtain();
        dest.writeInt(0);
        dest.writeString("accountUri");
        dest.writeInt(12345);
        dest.writeString("foldersList");
        dest.writeString("searchUri");
        dest.writeString("fromAddresses");
        dest.writeString("saveDraftUri");
        dest.writeString("sendMessageUri");
        dest.writeString("expungeMessageUri");
        dest.writeString("undoUri");
        dest.writeString("statusUri");
        dest.writeString("settingIntentUri");
        Account account = new Account(dest);
        Intent intent = new Intent();
        intent.putExtra(Utils.EXTRA_ACCOUNT, account);
        Account outAccount = (Account) intent.getParcelableExtra(Utils.EXTRA_ACCOUNT);
        assertEquals(outAccount.name, account.name);
        assertEquals(outAccount.accountFromAddressesUri, account.accountFromAddressesUri);
        assertEquals(outAccount.capabilities, account.capabilities);
        assertEquals(outAccount.providerVersion, account.providerVersion);
        assertEquals(outAccount.accountUri, account.accountUri);
        assertEquals(outAccount.folderListUri, account.folderListUri);
        assertEquals(outAccount.searchUri, account.searchUri);
        assertEquals(outAccount.saveDraftUri, account.saveDraftUri);
        assertEquals(outAccount.sendMessageUri, account.sendMessageUri);
        assertEquals(outAccount.expungeMessageUri, account.expungeMessageUri);
    }
}