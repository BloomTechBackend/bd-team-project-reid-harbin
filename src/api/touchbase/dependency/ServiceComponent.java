package api.touchbase.dependency;


import api.touchbase.activity.family.*;
import api.touchbase.activity.member.*;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { DaoModule.class })
public interface ServiceComponent {
    CreateMemberActivity provideCreateMemberActivity();

    GetMemberNotificationsActivity provideGetMemberNotificationsActivity();

    GetMemberActivity provideGetMemberDetailsActivity();

    DeleteMemberNotificationActivity provideDeleteMemberNotificationActivity();

    DeleteMemberActivity provideDeleteMemberActivity();

    CreateFamilyActivity provideCreateFamilyActivity();

    JoinFamilyActivity provideJoinFamilyActivity();

    GetFamilyActivity provideGetFamilyActivity();

    CreateEventActivity provideCreateEventActivity();

    GetEventsActivity provideGetEventsActivity();

    JoinEventActivity provideJoinEventActivity();

    MemberLoginActivity provideMemberLoginActivity();
}
