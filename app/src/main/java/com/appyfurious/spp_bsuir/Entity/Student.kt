package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmList

class Student {
    var name: String? = null
    var courseId: String? = null
    var certificates = RealmList<Certificate>()
    var comments = RealmList<Comment>()
}