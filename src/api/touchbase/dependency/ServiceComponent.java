package api.touchbase.dependency;


import api.touchbase.activity.*;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { DaoModule.class })
public interface ServiceComponent {
    CreateMemberActivity provideCreateMemberActivity();

    GetMemberNotificationsActivity provideGetMemberNotificationsActivity();

    GetMemberDetailsActivity provideGetMemberDetailsActivity();

    DeleteMemberNotificationActivity provideDeleteMemberNotificationActivity();

    DeleteMemberActivity provideDeleteMemberActivity();

    CreateFamilyActivity provideCreateFamilyActivity();

    JoinFamilyActivity provideJoinFamilyActivity();

    CreateEventActivity provideCreateEventActivity();

}
