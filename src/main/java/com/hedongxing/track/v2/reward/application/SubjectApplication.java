package com.hedongxing.track.v2.reward.application;

import com.hedongxing.track.v2.reward.model.Subject;

public interface SubjectApplication {

    Subject getSubjectById(String subjectId);

    String getTenantIdOfSubject(String subjectId);
}
