package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.FAQ;
import com.example.demo.repository.FAQRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private FAQRepository faqRepository;

    @Override
    public void run(String... args) {

        FAQ divisions = faqRepository.save(new FAQ(
            "divisions,department,justice,structure,wings,doj,प्रभाग,विभाग,संरचना,വിഭാഗങ്ങൾ,വകുപ്പ്,ഘടന",
            "What are the divisions of the Department of Justice?",
            "न्याय विभाग (DoJ) के प्रभाग कौन-कौन से हैं?",
            "നീതിന്യായ വകുപ്പിന്റെ (DoJ) വിഭാഗങ്ങൾ ഏതെല്ലാം?",
            "The Department of Justice (DoJ) functions under the Ministry of Law and Justice, Government of India. Its key areas include Access to Justice, Judicial Reforms, Infrastructure for the judiciary (courts, e-Courts), Legal Aid (NALSA/Tele-Law), Fast Track Courts, and Human Resources for the judiciary.",
            "न्याय विभाग विधि एवं न्याय मंत्रालय, भारत सरकार के अंतर्गत कार्य करता है। इसके प्रमुख कार्यक्षेत्रों में न्याय तक पहुंच, न्यायिक सुधार, न्यायपालिका के लिए अवसंरचना (अदालतें, ई-कोर्ट्स), विधिक सहायता (नालसा/टेली-लॉ), फास्ट ट्रैक कोर्ट्स और न्यायपालिका के लिए मानव संसाधन शामिल हैं।",
            "ഇന്ത്യാ ഗവൺമെന്റിന്റെ നിയമ, നീതിന്യായ മന്ത്രാലയത്തിന് കീഴിലാണ് നീതിന്യായ വകുപ്പ് (DoJ) പ്രവർത്തിക്കുന്നത്. നീതി ലഭ്യമാക്കൽ, ജുഡീഷ്യൽ പരിഷ്കാരങ്ങൾ, ജുഡീഷ്യറിക്കുള്ള അടിസ്ഥാന സൗകര്യങ്ങൾ (കോടതികൾ, ഇ-കോടതികൾ), നിയമസഹായം (നൽസ/ടെലി-ലോ), ഫാസ്റ്റ് ട്രാക്ക് കോടതികൾ, ജുഡീഷ്യറിക്കുള്ള മാനവ വിഭവശേഷി എന്നിവയാണ് പ്രധാന പ്രവർത്തന മേഖലകൾ.",
            null));

        FAQ vacancies = faqRepository.save(new FAQ(
            "judge,vacancy,vacancies,sanctioned,strength,judges,न्यायाधीश,रिक्त,रिक्तियां,स्वीकृत संख्या,ജഡ്ജി,ഒഴിവ്,ഒഴിവുകൾ,ജഡ്ജിമാർ",
            "How many judges are there and what are the current vacancies?",
            "वर्तमान में न्यायाधीशों की संख्या और रिक्तियां कितनी हैं?",
            "എത്ര ജഡ്ജിമാരുണ്ട്, നിലവിലെ ഒഴിവുകൾ എത്രയാണ്?",
            "As per DoJ data (illustrative figures for this demo), the sanctioned strength of judges in High Courts is around 1,114, with approximately 340 vacancies. The Supreme Court has a sanctioned strength of 34 judges. Live figures are available on the DoJ website and NJDG portal.",
            "DoJ के आंकड़ों के अनुसार (इस डेमो के लिए उदाहरणात्मक आंकड़े), उच्च न्यायालयों में न्यायाधीशों की स्वीकृत संख्या लगभग 1,114 है, जिसमें लगभग 340 पद रिक्त हैं। सर्वोच्च न्यायालय की स्वीकृत संख्या 34 न्यायाधीश है। वास्तविक आंकड़े DoJ वेबसाइट और NJDG पोर्टल पर उपलब्ध हैं।",
            "DoJ യുടെ കണക്കുകൾ പ്രകാരം (ഈ ഡെമോയ്ക്കുള്ള മാതൃകാ കണക്കുകൾ), ഹൈക്കോടതികളിലെ അനുവദിച്ച ജഡ്ജിമാരുടെ എണ്ണം ഏകദേശം 1,114 ആണ്, ഏകദേശം 340 ഒഴിവുകളുണ്ട്. സുപ്രീം കോടതിയിൽ അനുവദിച്ചിട്ടുള്ളത് 34 ജഡ്ജിമാരാണ്. യഥാർത്ഥ കണക്കുകൾ DoJ വെബ്സൈറ്റിലും NJDG പോർട്ടലിലും ലഭ്യമാണ്.",
            null));

        FAQ pendency = faqRepository.save(new FAQ(
            "pendency,pending,cases,njdg,national judicial data grid,लंबित,पेंडेंसी,मामले,കെട്ടിക്കിടക്കുന്ന,കേസുകൾ,പെൻഡൻസി",
            "How can I check case pendency data?",
            "मैं केस पेंडेंसी (लंबित मामलों) के आंकड़े कैसे देख सकता हूं?",
            "കേസ് കെട്ടിക്കിടക്കുന്നതിന്റെ (pendency) വിവരങ്ങൾ എങ്ങനെ പരിശോധിക്കാം?",
            "Case pendency across Indian courts can be tracked via the National Judicial Data Grid (NJDG) at njdg.ecourts.gov.in. It shows pending case statistics for the Supreme Court, High Courts, and District/Taluka courts, updated regularly (illustrative demo figure: approx. 4.5 crore cases pending nationwide).",
            "भारत की अदालतों में लंबित मामलों के आंकड़े राष्ट्रीय न्यायिक डेटा ग्रिड (NJDG) पर njdg.ecourts.gov.in के माध्यम से देखे जा सकते हैं। यह सर्वोच्च न्यायालय, उच्च न्यायालयों और जिला/तालुका अदालतों के लंबित मामलों के आंकड़े नियमित रूप से अपडेट करता है (उदाहरण के लिए, लगभग 4.5 करोड़ मामले देशभर में लंबित हैं)।",
            "ഇന്ത്യൻ കോടതികളിലെ കെട്ടിക്കിടക്കുന്ന കേസുകളുടെ വിവരങ്ങൾ നാഷണൽ ജുഡീഷ്യൽ ഡാറ്റ ഗ്രിഡ് (NJDG) വഴി njdg.ecourts.gov.in ൽ കാണാം. സുപ്രീം കോടതി, ഹൈക്കോടതികൾ, ജില്ലാ/താലൂക്ക് കോടതികൾ എന്നിവയിലെ കെട്ടിക്കിടക്കുന്ന കേസുകളുടെ കണക്കുകൾ ഇത് സ്ഥിരമായി അപ്ഡേറ്റ് ചെയ്യുന്നു (ഉദാഹരണത്തിന്, രാജ്യത്താകെ ഏകദേശം 4.5 കോടി കേസുകൾ കെട്ടിക്കിടക്കുന്നു).",
            null));

        FAQ trafficFine = faqRepository.save(new FAQ(
            "traffic,fine,challan,violation,जुर्माना,चालान,ट्रैफिक,ട്രാഫിക്,പിഴ,ചലാൻ",
            "How do I pay a traffic fine?",
            "मैं ट्रैफिक जुर्माना कैसे भरूं?",
            "ട്രാഫിക് പിഴ എങ്ങനെ അടയ്ക്കാം?",
            "You can pay traffic fines online via the eChallan portal (echallan.parivahan.gov.in). Steps: 1) Enter your challan number, vehicle number, or driving licence number, 2) Verify the challan details, 3) Pay using UPI, debit/credit card, or net banking, 4) Download the payment receipt. Fines can also be paid at the nearest traffic police counter.",
            "आप eChallan पोर्टल (echallan.parivahan.gov.in) के माध्यम से ऑनलाइन ट्रैफिक जुर्माना भर सकते हैं। चरण: 1) अपना चालान नंबर, वाहन नंबर या ड्राइविंग लाइसेंस नंबर दर्ज करें, 2) चालान विवरण सत्यापित करें, 3) UPI, डेबिट/क्रेडिट कार्ड या नेट बैंकिंग से भुगतान करें, 4) भुगतान रसीद डाउनलोड करें। जुर्माना निकटतम ट्रैफिक पुलिस काउंटर पर भी भरा जा सकता है।",
            "eChallan പോർട്ടൽ (echallan.parivahan.gov.in) വഴി നിങ്ങൾക്ക് ട്രാഫിക് പിഴ ഓൺലൈനായി അടയ്ക്കാം. ഘട്ടങ്ങൾ: 1) ചലാൻ നമ്പർ, വാഹന നമ്പർ, അല്ലെങ്കിൽ ഡ്രൈവിംഗ് ലൈസൻസ് നമ്പർ നൽകുക, 2) ചലാൻ വിവരങ്ങൾ പരിശോധിക്കുക, 3) UPI, ഡെബിറ്റ്/ക്രെഡിറ്റ് കാർഡ്, അല്ലെങ്കിൽ നെറ്റ് ബാങ്കിംഗ് വഴി പണം അടയ്ക്കുക, 4) പേയ്മെന്റ് രസീത് ഡൗൺലോഡ് ചെയ്യുക. ഏറ്റവും അടുത്തുള്ള ട്രാഫിക് പോലീസ് കൗണ്ടറിലും പിഴ അടയ്ക്കാവുന്നതാണ്.",
            null));

        FAQ liveStreaming = faqRepository.save(new FAQ(
            "live,streaming,stream,broadcast,court proceedings,लाइव,स्ट्रीमिंग,सीधा प्रसारण,തത്സമയം,സംപ്രേഷണം,ലൈവ്",
            "How can I watch live streaming of court cases?",
            "मैं अदालती मामलों की लाइव स्ट्रीमिंग कैसे देख सकता हूं?",
            "കോടതി നടപടികളുടെ തത്സമയ സംപ്രേഷണം (live streaming) എങ്ങനെ കാണാം?",
            "Select High Courts and the Supreme Court of India live-stream select court proceedings on their official YouTube channels and websites, in line with the e-Committee's Model Live Streaming Rules. Check the respective High Court or Supreme Court website for the live streaming link and case schedule.",
            "चुनिंदा उच्च न्यायालय और भारत का सर्वोच्च न्यायालय अपनी आधिकारिक वेबसाइट और YouTube चैनल पर चुनिंदा अदालती कार्यवाही की लाइव स्ट्रीमिंग करते हैं, जो ई-समिति के मॉडल लाइव स्ट्रीमिंग नियमों के अनुरूप है। लाइव स्ट्रीमिंग लिंक और मामलों की सूची के लिए संबंधित उच्च न्यायालय या सर्वोच्च न्यायालय की वेबसाइट देखें।",
            "തിരഞ്ഞെടുത്ത ഹൈക്കോടതികളും ഇന്ത്യയുടെ സുപ്രീം കോടതിയും അവരുടെ ഔദ്യോഗിക വെബ്സൈറ്റിലും YouTube ചാനലിലും ചില കോടതി നടപടികൾ തത്സമയം സംപ്രേഷണം ചെയ്യുന്നു, ഇ-കമ്മിറ്റിയുടെ മോഡൽ ലൈവ് സ്ട്രീമിംഗ് നിയമങ്ങൾക്ക് അനുസൃതമായി. ലൈവ് സ്ട്രീമിംഗ് ലിങ്കിനും കേസ് ഷെഡ്യൂളിനും ബന്ധപ്പെട്ട ഹൈക്കോടതി അല്ലെങ്കിൽ സുപ്രീം കോടതി വെബ്സൈറ്റ് പരിശോധിക്കുക.",
            null));

        FAQ efiling = faqRepository.save(new FAQ(
            "efiling,e-filing,epay,e-pay,file case online,court fee,फाइलिंग,फाइल,फीस,भुगतान,ഫയൽ,ഫീസ്,പേയ്മെന്റ്",
            "How do I e-File a case and pay court fees online?",
            "मैं ऑनलाइन केस कैसे फाइल करूं और कोर्ट फीस कैसे भरूं?",
            "ഓൺലൈനായി കേസ് ഫയൽ ചെയ്യുന്നതും കോടതി ഫീസ് അടയ്ക്കുന്നതും എങ്ങനെ?",
            "You can e-File a case through the eCourts eFiling portal (efiling.ecourts.gov.in). Steps: 1) Register with your mobile/email, 2) Fill case details and upload documents (petition, affidavits, vakalatnama), 3) Pay court fees online via ePay (integrated payment gateway), 4) Submit for scrutiny by the filing counter. You'll receive an acknowledgment number to track status.",
            "आप eCourts eFiling पोर्टल (efiling.ecourts.gov.in) के माध्यम से केस ई-फाइल कर सकते हैं। चरण: 1) मोबाइल/ईमेल से पंजीकरण करें, 2) केस विवरण भरें और दस्तावेज़ (याचिका, हलफनामा, वकालतनामा) अपलोड करें, 3) एकीकृत भुगतान गेटवे के माध्यम से ePay से कोर्ट फीस ऑनलाइन भरें, 4) फाइलिंग काउंटर द्वारा जांच हेतु सबमिट करें। आपको स्थिति ट्रैक करने के लिए एक पावती संख्या प्राप्त होगी।",
            "eCourts eFiling പോർട്ടൽ (efiling.ecourts.gov.in) വഴി നിങ്ങൾക്ക് കേസ് ഇ-ഫയൽ ചെയ്യാം. ഘട്ടങ്ങൾ: 1) മൊബൈൽ/ഇമെയിൽ ഉപയോഗിച്ച് രജിസ്റ്റർ ചെയ്യുക, 2) കേസ് വിവരങ്ങൾ പൂരിപ്പിച്ച് രേഖകൾ (ഹർജി, സത്യവാങ്മൂലം, വക്കാലത്ത്) അപ്‌ലോഡ് ചെയ്യുക, 3) സംയോജിത പേയ്മെന്റ് ഗേറ്റ്‌വേ വഴി ePay ഉപയോഗിച്ച് കോടതി ഫീസ് ഓൺലൈനായി അടയ്ക്കുക, 4) ഫയലിംഗ് കൗണ്ടറിന്റെ പരിശോധനയ്ക്കായി സമർപ്പിക്കുക. നിലയറിയാൻ ഒരു അക്നോളജ്മെന്റ് നമ്പർ നിങ്ങൾക്ക് ലഭിക്കും.",
            null));

        FAQ fastTrack = faqRepository.save(new FAQ(
            "fast track,ftc,special courts,speedy trial,फास्ट ट्रैक,त्वरित सुनवाई,ഫാസ്റ്റ് ട്രാക്ക്,പ്രത്യേക കോടതി",
            "What are Fast Track Courts?",
            "फास्ट ट्रैक कोर्ट क्या हैं?",
            "എന്താണ് ഫാസ്റ്റ് ട്രാക്ക് കോടതികൾ?",
            "Fast Track Courts (FTCs) are special courts set up to ensure speedy disposal of cases, particularly those involving crimes against women and children, and long-pending cases. The DoJ, along with state governments, funds and monitors FTCs, including Fast Track Special Courts (FTSCs) for POCSO Act cases.",
            "फास्ट ट्रैक कोर्ट (FTC) विशेष अदालतें हैं जो मामलों के त्वरित निपटान को सुनिश्चित करने के लिए स्थापित की गई हैं, विशेष रूप से महिलाओं और बच्चों के खिलाफ अपराधों तथा लंबे समय से लंबित मामलों के लिए। न्याय विभाग राज्य सरकारों के साथ मिलकर POCSO अधिनियम के मामलों के लिए फास्ट ट्रैक स्पेशल कोर्ट्स (FTSC) सहित FTCs को वित्त पोषित और मॉनिटर करता है।",
            "കേസുകളുടെ വേഗത്തിലുള്ള തീർപ്പാക്കൽ ഉറപ്പാക്കാൻ സ്ഥാപിച്ചിട്ടുള്ള പ്രത്യേക കോടതികളാണ് ഫാസ്റ്റ് ട്രാക്ക് കോടതികൾ (FTC), പ്രത്യേകിച്ച് സ്ത്രീകൾക്കും കുട്ടികൾക്കും എതിരായ കുറ്റകൃത്യങ്ങൾ ഉൾപ്പെടുന്നവയും ദീർഘകാലമായി കെട്ടിക്കിടക്കുന്നവയും. POCSO നിയമ കേസുകൾക്കായുള്ള ഫാസ്റ്റ് ട്രാക്ക് സ്പെഷ്യൽ കോടതികൾ (FTSC) ഉൾപ്പെടെ, സംസ്ഥാന സർക്കാരുകളുമായി ചേർന്ന് DoJ ഇവയ്ക്ക് ധനസഹായം നൽകുകയും നിരീക്ഷിക്കുകയും ചെയ്യുന്നു.",
            null));

        FAQ ecourtsApp = faqRepository.save(new FAQ(
            "ecourts app,mobile app,download,case status app,डाउनलोड,ऐप,एप्लिकेशन,ഡൗൺലോഡ്,ആപ്പ്",
            "How do I download the eCourts app?",
            "मैं eCourts ऐप कैसे डाउनलोड करूं?",
            "eCourts ആപ്പ് എങ്ങനെ ഡൗൺലോഡ് ചെയ്യാം?",
            "The eCourts Services mobile app is available for free on the Google Play Store (Android) and Apple App Store (iOS). Search 'eCourts Services' and install it. The app lets you check case status, cause lists, orders/judgments, and court notices using your CNR number or case details.",
            "eCourts Services मोबाइल ऐप Google Play Store (Android) और Apple App Store (iOS) पर मुफ्त उपलब्ध है। 'eCourts Services' खोजें और इंस्टॉल करें। यह ऐप CNR नंबर या केस विवरण का उपयोग करके केस की स्थिति, कॉज़ लिस्ट, आदेश/निर्णय और अदालत की सूचनाएं देखने की सुविधा देता है।",
            "eCourts Services മൊബൈൽ ആപ്പ് Google Play Store (Android), Apple App Store (iOS) എന്നിവയിൽ സൗജന്യമായി ലഭ്യമാണ്. 'eCourts Services' എന്ന് തിരഞ്ഞ് ഇൻസ്റ്റാൾ ചെയ്യുക. CNR നമ്പർ അല്ലെങ്കിൽ കേസ് വിവരങ്ങൾ ഉപയോഗിച്ച് കേസിന്റെ നില, കോസ് ലിസ്റ്റ്, ഉത്തരവുകൾ/വിധികൾ, കോടതി അറിയിപ്പുകൾ എന്നിവ പരിശോധിക്കാൻ ഈ ആപ്പ് സഹായിക്കുന്നു.",
            null));

        FAQ teleLaw = faqRepository.save(new FAQ(
            "tele law,tele-law,legal aid,cscs,paralegal,टेली लॉ,टेली-लॉ,कानूनी सहायता,ടെലി ലോ,നിയമസഹായം",
            "What is Tele-Law and how can I access it?",
            "टेली-लॉ क्या है और मैं इसका उपयोग कैसे कर सकता हूं?",
            "എന്താണ് ടെലി-ലോ, എങ്ങനെ ഇത് ഉപയോഗിക്കാം?",
            "Tele-Law is a DoJ initiative that connects citizens, especially in rural areas, with panel lawyers via video conferencing or telephone through Common Service Centres (CSCs). It provides free basic legal advice. Visit your nearest CSC or the tele-law.in portal to book a consultation with a panel lawyer or paralegal volunteer.",
            "टेली-लॉ न्याय विभाग की एक पहल है जो नागरिकों, विशेष रूप से ग्रामीण क्षेत्रों में, को कॉमन सर्विस सेंटर (CSC) के माध्यम से वीडियो कॉन्फ्रेंसिंग/टेलीफोन द्वारा पैनल वकीलों से जोड़ती है। यह निःशुल्क बुनियादी कानूनी सलाह प्रदान करती है। परामर्श बुक करने के लिए अपने निकटतम CSC या tele-law.in पोर्टल पर जाएं।",
            "സാധാരണ സേവന കേന്ദ്രങ്ങൾ (CSC) വഴി വീഡിയോ കോൺഫറൻസിംഗ്/ടെലിഫോൺ മുഖേന പൗരന്മാരെ, പ്രത്യേകിച്ച് ഗ്രാമീണ മേഖലയിലുള്ളവരെ, പാനൽ അഭിഭാഷകരുമായി ബന്ധിപ്പിക്കുന്ന DoJ യുടെ ഒരു സംരംഭമാണ് ടെലി-ലോ. ഇത് സൗജന്യ അടിസ്ഥാന നിയമോപദേശം നൽകുന്നു. പാനൽ അഭിഭാഷകനുമായോ പാരാലീഗൽ വോളന്റിയറുമായോ കൺസൾട്ടേഷൻ ബുക്ക് ചെയ്യാൻ നിങ്ങളുടെ ഏറ്റവും അടുത്തുള്ള CSC സന്ദർശിക്കുക അല്ലെങ്കിൽ tele-law.in പോർട്ടൽ ഉപയോഗിക്കുക.",
            null));

        FAQ caseStatus = faqRepository.save(new FAQ(
            "case status,check case,cnr,case number,track case,केस स्टेटस,स्थिति,केस की स्थिति,കേസ് നില,സ്റ്റാറ്റസ്",
            "How do I check my case status?",
            "मैं अपने केस की स्थिति कैसे जांचूं?",
            "എന്റെ കേസിന്റെ നില എങ്ങനെ പരിശോധിക്കാം?",
            "You can check case status on the eCourts Services portal (services.ecourts.gov.in) or the eCourts mobile app using your CNR (Case Number Record) number, or by searching with party name, filing number, or FIR number. The CNR number is a unique 16-digit identifier assigned to every case.",
            "आप eCourts Services पोर्टल (services.ecourts.gov.in) या eCourts मोबाइल ऐप पर अपने CNR (केस नंबर रिकॉर्ड) नंबर का उपयोग करके, या पक्षकार के नाम, फाइलिंग नंबर या FIR नंबर से खोज कर केस की स्थिति देख सकते हैं। CNR नंबर हर मामले को दिया गया एक अद्वितीय 16-अंकीय पहचान संख्या है।",
            "eCourts Services പോർട്ടൽ (services.ecourts.gov.in) അല്ലെങ്കിൽ eCourts മൊബൈൽ ആപ്പ് വഴി നിങ്ങളുടെ CNR (Case Number Record) നമ്പർ ഉപയോഗിച്ചോ, കക്ഷിയുടെ പേര്, ഫയലിംഗ് നമ്പർ, അല്ലെങ്കിൽ FIR നമ്പർ ഉപയോഗിച്ച് തിരഞ്ഞോ കേസിന്റെ നില പരിശോധിക്കാം. ഓരോ കേസിനും നൽകുന്ന അദ്വിതീയ 16 അക്ക തിരിച്ചറിയൽ നമ്പറാണ് CNR നമ്പർ.",
            null));

        divisions.setRelatedQuestionIds(vacancies.getId() + "," + pendency.getId());
        vacancies.setRelatedQuestionIds(divisions.getId() + "," + pendency.getId());
        pendency.setRelatedQuestionIds(vacancies.getId() + "," + caseStatus.getId());
        trafficFine.setRelatedQuestionIds(ecourtsApp.getId() + "," + caseStatus.getId());
        liveStreaming.setRelatedQuestionIds(caseStatus.getId() + "," + efiling.getId());
        efiling.setRelatedQuestionIds(caseStatus.getId() + "," + ecourtsApp.getId());
        fastTrack.setRelatedQuestionIds(pendency.getId() + "," + caseStatus.getId());
        ecourtsApp.setRelatedQuestionIds(caseStatus.getId() + "," + efiling.getId());
        teleLaw.setRelatedQuestionIds(efiling.getId() + "," + caseStatus.getId());
        caseStatus.setRelatedQuestionIds(ecourtsApp.getId() + "," + pendency.getId());

        faqRepository.save(divisions);
        faqRepository.save(vacancies);
        faqRepository.save(pendency);
        faqRepository.save(trafficFine);
        faqRepository.save(liveStreaming);
        faqRepository.save(efiling);
        faqRepository.save(fastTrack);
        faqRepository.save(ecourtsApp);
        faqRepository.save(teleLaw);
        faqRepository.save(caseStatus);
    }
}