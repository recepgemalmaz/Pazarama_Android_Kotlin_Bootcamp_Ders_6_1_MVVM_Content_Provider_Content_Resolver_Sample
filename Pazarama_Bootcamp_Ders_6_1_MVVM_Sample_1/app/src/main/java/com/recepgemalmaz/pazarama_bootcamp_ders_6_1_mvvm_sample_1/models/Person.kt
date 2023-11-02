package com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1.models

data class  Person(
    val id: String?,
    val name: String?,
    var phone: String?
)


//ONEMLI!!!!!

//IPC MEKANIZMALARI
//IPC: Inter Process Communication
//IPC Mekanizmaları: Processler arası iletişim mekanizmaları
//IPC Mekanizmaları: Shared Memory, Message Passing, Pipe, Socket


//CONTENT PROVIDER / CONTENT RESOLVER
//Content Provider: Uygulamaların verilerini diğer uygulamalarla paylaşmasını sağlayan mekanizmadır.
//Content Resolver: Content Provider'a erişmek için kullanılan mekanizmadır.

//Eger bir uygulama content provider kullanarak veri paylasimi yapmak istiyorsa
//ancak o zaman uygulamaniz ile  content resolver kullanarak karsi uygulamanin    content provider'a erisebilir.

