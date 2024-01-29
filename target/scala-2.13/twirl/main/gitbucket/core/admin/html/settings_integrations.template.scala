
package gitbucket.core.admin.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object settings_integrations extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.util.DatabaseConfig


Seq[Any](format.raw/*3.1*/("""<!--====================================================================-->
<!-- Services -->
<!--====================================================================-->
<label class="strong">Services</label>
<fieldset>
  <label class="checkbox">
    <input type="checkbox" name="basicBehavior.gravatar""""),_display_(if(context.settings.basicBehavior.gravatar)/*9.101*/{_display_(Seq[Any](format.raw/*9.102*/(""" """),format.raw/*9.103*/("""checked""")))} else {null} ),format.raw/*9.111*/("""/>
    Use Gravatar for profile images
  </label>
</fieldset>
<!--====================================================================-->
<!-- SSH access -->
<!--====================================================================-->
<hr>
<label class="strong">SSH access</label>
<fieldset>
  <label class="checkbox">
    <input type="checkbox" id="sshEnabled" name="ssh.enabled""""),_display_(if(context.settings.ssh.enabled)/*20.95*/{_display_(Seq[Any](format.raw/*20.96*/(""" """),format.raw/*20.97*/("""checked""")))} else {null} ),format.raw/*20.105*/("""/>
    Enable SSH access to git repository
    <span class="muted normal">(Both SSH bind host and Base URL are required if SSH access is enabled)</span>
  </label>
</fieldset>
<div class="ssh">
  <div class="bindAddress">
    <div class="form-group">
      <label class="control-label col-md-2" for="sshBindHost">SSH bind host</label>
      <div class="col-md-10">
        <input type="text" id="sshBindHost" name="ssh.bindAddress.host" class="form-control" value=""""),_display_(/*30.102*/context/*30.109*/.settings.ssh.bindAddress.map(_.host)),format.raw/*30.146*/(""""/>
        <span id="error-ssh_bindAddress_host" class="error"></span>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-md-2" for="sshBindPort">SSH bind port</label>
      <div class="col-md-10">
        <input type="text" id="sshBindPort" name="ssh.bindAddress.port" class="form-control" value=""""),_display_(/*37.102*/context/*37.109*/.settings.ssh.bindAddress.map(_.port)),format.raw/*37.146*/(""""/>
        <span id="error-ssh_bindAddress_port" class="error"></span>
      </div>
    </div>
  </div>
  <div class="publicAddress">
    <div class="form-group">
      <label class="control-label col-md-2" for="sshPublicHost">SSH public host</label>
      <div class="col-md-10">
        <input type="text" id="sshPublicHost" name="ssh.publicAddress.host" class="form-control" value=""""),_display_(/*46.106*/context/*46.113*/.settings.ssh.publicAddress.map(_.host)),format.raw/*46.152*/(""""/>
        <span id="error-ssh_publicAddress_host" class="error"></span>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-md-2" for="sshPublicPort">SSH public port</label>
      <div class="col-md-10">
        <input type="text" id="sshPublicPort" name="ssh.publicAddress.port" class="form-control" value=""""),_display_(/*53.106*/context/*53.113*/.settings.ssh.publicAddress.map(_.port)),format.raw/*53.152*/(""""/>
        <span id="error-ssh_publicAddress_port" class="error"></span>
      </div>
    </div>
  </div>
</div>
<!--====================================================================-->
<!-- Communication email -->
<!--====================================================================-->
<hr>
<label class="strong">Communication</label>
<fieldset>
  <label class="checkbox">
    <input type="checkbox" id="useSMTP" name="useSMTP" """),_display_(if(context.settings.useSMTP)/*66.85*/{_display_(Seq[Any](format.raw/*66.86*/(""" """),format.raw/*66.87*/("""checked""")))} else {null} ),format.raw/*66.95*/("""/>
    SMTP
    <span class="muted normal">(Enable notification as well as SMTP configuration if you want to send notification email too)</span>
  </label>
</fieldset>
<div class="useSMTP">
  <div class="form-group">
    <label class="control-label col-md-2" for="smtpHost">SMTP host</label>
    <div class="col-md-10">
      <input type="text" id="smtpHost" name="smtp.host" class="form-control" value=""""),_display_(/*75.86*/context/*75.93*/.settings.smtp.map(_.host)),format.raw/*75.119*/(""""/>
      <span id="error-smtp_host" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="smtpPort">SMTP port</label>
    <div class="col-md-10">
      <input type="text" id="smtpPort" name="smtp.port" class="form-control input-mini" value=""""),_display_(/*82.97*/context/*82.104*/.settings.smtp.map(_.port)),format.raw/*82.130*/(""""/>
      <span id="error-smtp_port" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="smtpUser">SMTP user</label>
    <div class="col-md-10">
      <input type="text" id="smtpUser" name="smtp.user" class="form-control" value=""""),_display_(/*89.86*/context/*89.93*/.settings.smtp.map(_.user)),format.raw/*89.119*/(""""/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="smtpPassword">SMTP password</label>
    <div class="col-md-10">
      <input type="password" id="smtpPassword" name="smtp.password" class="form-control" value=""""),_display_(/*95.98*/context/*95.105*/.settings.smtp.map(_.password)),format.raw/*95.135*/(""""/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="smtpSsl">Enable SSL</label>
    <div class="col-md-10">
      <input type="checkbox" id="smtpSsl" name="smtp.ssl""""),_display_(if(context.settings.smtp.flatMap(_.ssl).getOrElse(false))/*101.116*/{_display_(Seq[Any](format.raw/*101.117*/(""" """),format.raw/*101.118*/("""checked""")))} else {null} ),format.raw/*101.126*/("""/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="smtpStarttls">Enable STARTTLS</label>
    <div class="col-md-10">
      <input type="checkbox" id="smtpStarttls" name="smtp.starttls""""),_display_(if(context.settings.smtp.flatMap(_.starttls).getOrElse(false))/*107.131*/{_display_(Seq[Any](format.raw/*107.132*/(""" """),format.raw/*107.133*/("""checked""")))} else {null} ),format.raw/*107.141*/("""/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="fromAddress">FROM address</label>
    <div class="col-md-10">
      <input type="text" id="fromAddress" name="smtp.fromAddress" class="form-control" value=""""),_display_(/*113.96*/context/*113.103*/.settings.smtp.map(_.fromAddress)),format.raw/*113.136*/(""""/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="fromName">FROM name</label>
    <div class="col-md-10">
      <input type="text" id="fromName" name="smtp.fromName" class="form-control" value=""""),_display_(/*119.90*/context/*119.97*/.settings.smtp.map(_.fromName)),format.raw/*119.127*/(""""/>
    </div>
  </div>
  <div class="text-right">
    Send test mail to:
    <input type="text" id="testAddress" size="30"/>
    <input type="button" id="sendTestMail" value="Send"/>
  </div>
</div>
<!--====================================================================-->
<!-- Notification email -->
<!--====================================================================-->
<hr>
<label class="strong">Notifications</label>
<fieldset>
  <label class="checkbox" for="notification">
    <input type="checkbox" id="notification" name="basicBehavior.notification""""),_display_(if(context.settings.basicBehavior.notification)/*135.127*/{_display_(Seq[Any](format.raw/*135.128*/(""" """),format.raw/*135.129*/("""checked""")))} else {null} ),format.raw/*135.137*/("""/>
    Send notifications
  </label>
</fieldset>
<!--====================================================================-->
<!-- Web hook -->
<!--====================================================================-->
<hr>
<label class="strong">Web hook</label>
<fieldset>
  <label class="checkbox" for="blockPrivateAddress">
    <input type="checkbox" id="blockPrivateAddress" name="webhook.blockPrivateAddress""""),_display_(if(context.settings.webHook.blockPrivateAddress)/*146.136*/{_display_(Seq[Any](format.raw/*146.137*/(""" """),format.raw/*146.138*/("""checked""")))} else {null} ),format.raw/*146.146*/("""/>
    Block sending to private addresses
  </label>
</fieldset>
<div class="webhook">
  <label><span class="strong">IP whitelist</span></label>
  <fieldset>
    <textarea name="webhook.whitelist" class="form-control" style="height: 100px;">"""),_display_(/*153.85*/context/*153.92*/.settings.webHook.whitelist.mkString("\n")),format.raw/*153.134*/("""</textarea>
  </fieldset>
</div>
<script>
$(function()"""),format.raw/*157.13*/("""{"""),format.raw/*157.14*/("""
  """),format.raw/*158.3*/("""$('#sendTestMail').click(function()"""),format.raw/*158.38*/("""{"""),format.raw/*158.39*/("""
    """),format.raw/*159.5*/("""var host        = $('#smtpHost'    ).val();
    var port        = $('#smtpPort'    ).val();
    var user        = $('#smtpUser'    ).val();
    var password    = $('#smtpPassword').val();
    var ssl         = $('#smtpSsl'     ).prop('checked');
    var starttls    = $('#smtpStarttls').prop('checked');
    var fromAddress = $('#fromAddress' ).val();
    var fromName    = $('#fromName'    ).val();
    var testAddress = $('#testAddress' ).val();

    if(host == '')"""),format.raw/*169.19*/("""{"""),format.raw/*169.20*/("""
      """),format.raw/*170.7*/("""alert('SMTP Host is required.');
      $('#smtpHost').focus();
    """),format.raw/*172.5*/("""}"""),format.raw/*172.6*/(""" """),format.raw/*172.7*/("""else if(testAddress == '')"""),format.raw/*172.33*/("""{"""),format.raw/*172.34*/("""
      """),format.raw/*173.7*/("""alert('Destination is required.');
      $('#testAddress').focus();
    """),format.raw/*175.5*/("""}"""),format.raw/*175.6*/(""" """),format.raw/*175.7*/("""else """),format.raw/*175.12*/("""{"""),format.raw/*175.13*/("""
      """),format.raw/*176.7*/("""$.post('"""),_display_(/*176.16*/context/*176.23*/.path),format.raw/*176.28*/("""/admin/system/sendmail', """),format.raw/*176.53*/("""{"""),format.raw/*176.54*/("""
        """),format.raw/*177.9*/("""'smtp.host': host,
        'smtp.port': port,
        'smtp.user': user,
        'smtp.password': password,
        'smtp.ssl': ssl,
        'smtp.starttls': starttls,
        'smtp.fromAddress': fromAddress,
        'smtp.fromName': fromName,
        'testAddress': testAddress
      """),format.raw/*186.7*/("""}"""),format.raw/*186.8*/(""", function(data, status)"""),format.raw/*186.32*/("""{"""),format.raw/*186.33*/("""
        """),format.raw/*187.9*/("""if(data != '')"""),format.raw/*187.23*/("""{"""),format.raw/*187.24*/("""
          """),format.raw/*188.11*/("""alert(data);
        """),format.raw/*189.9*/("""}"""),format.raw/*189.10*/("""
      """),format.raw/*190.7*/("""}"""),format.raw/*190.8*/(""");
    """),format.raw/*191.5*/("""}"""),format.raw/*191.6*/("""
  """),format.raw/*192.3*/("""}"""),format.raw/*192.4*/(""");

  $('#sshEnabled').change(function()"""),format.raw/*194.37*/("""{"""),format.raw/*194.38*/("""
    """),format.raw/*195.5*/("""$('.ssh input').prop('disabled', !$(this).prop('checked'));
  """),format.raw/*196.3*/("""}"""),format.raw/*196.4*/(""").change();

  $('#useSMTP').change(function()"""),format.raw/*198.34*/("""{"""),format.raw/*198.35*/("""
    """),format.raw/*199.5*/("""$('.useSMTP input').prop('disabled', !$(this).prop('checked'));

    // With only SMTP in current version, notification cannot be enabled if no communication channel exists
    $('#notification').prop('disabled', !$(this).prop('checked'));

    if (!$(this).prop('checked')) """),format.raw/*204.35*/("""{"""),format.raw/*204.36*/("""
      """),format.raw/*205.7*/("""// With only SMTP in current version, if SMTP is unchecked then we disable notification
      $('#notification').prop('checked', false);
    """),format.raw/*207.5*/("""}"""),format.raw/*207.6*/("""
  """),format.raw/*208.3*/("""}"""),format.raw/*208.4*/(""").change();

  $('#blockPrivateAddress').change(function()"""),format.raw/*210.46*/("""{"""),format.raw/*210.47*/("""
    """),format.raw/*211.5*/("""$('.webhook textarea').prop('disabled', !$(this).prop('checked'));
  """),format.raw/*212.3*/("""}"""),format.raw/*212.4*/(""").change();
"""),format.raw/*213.1*/("""}"""),format.raw/*213.2*/(""");
</script>
"""))
      }
    }
  }

  def render(info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(info)(context)

  def f:((Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (info) => (context) => apply(info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/admin/settings_integrations.scala.html
                  HASH: 06e94eecb9ea7d12c7f84711983497d8aaed634c
                  MATRIX: 636->1|781->75|851->117|1225->464|1264->465|1293->466|1345->474|1784->886|1823->887|1852->888|1905->896|2399->1362|2416->1369|2475->1406|2843->1746|2860->1753|2919->1790|3334->2177|3351->2184|3412->2223|3790->2573|3807->2580|3868->2619|4361->3085|4400->3086|4429->3087|4481->3095|4913->3500|4929->3507|4977->3533|5309->3838|5326->3845|5374->3871|5695->4165|5711->4172|5759->4198|6045->4457|6062->4464|6114->4494|6412->4763|6453->4764|6484->4765|6538->4773|6860->5066|6901->5067|6932->5068|6986->5076|7268->5330|7286->5337|7342->5370|7613->5613|7630->5620|7683->5650|8324->6262|8365->6263|8396->6264|8450->6272|8941->6734|8982->6735|9013->6736|9067->6744|9337->6986|9354->6993|9419->7035|9502->7089|9532->7090|9563->7093|9627->7128|9657->7129|9690->7134|10186->7601|10216->7602|10251->7609|10346->7676|10375->7677|10404->7678|10459->7704|10489->7705|10524->7712|10624->7784|10653->7785|10682->7786|10716->7791|10746->7792|10781->7799|10818->7808|10835->7815|10862->7820|10916->7845|10946->7846|10983->7855|11296->8140|11325->8141|11378->8165|11408->8166|11445->8175|11488->8189|11518->8190|11558->8201|11607->8222|11637->8223|11672->8230|11701->8231|11736->8238|11765->8239|11796->8242|11825->8243|11894->8283|11924->8284|11957->8289|12047->8351|12076->8352|12151->8398|12181->8399|12214->8404|12518->8679|12548->8680|12583->8687|12752->8828|12781->8829|12812->8832|12841->8833|12928->8891|12958->8892|12991->8897|13088->8966|13117->8967|13157->8979|13186->8980
                  LINES: 14->1|17->2|20->3|26->9|26->9|26->9|26->9|37->20|37->20|37->20|37->20|47->30|47->30|47->30|54->37|54->37|54->37|63->46|63->46|63->46|70->53|70->53|70->53|83->66|83->66|83->66|83->66|92->75|92->75|92->75|99->82|99->82|99->82|106->89|106->89|106->89|112->95|112->95|112->95|118->101|118->101|118->101|118->101|124->107|124->107|124->107|124->107|130->113|130->113|130->113|136->119|136->119|136->119|152->135|152->135|152->135|152->135|163->146|163->146|163->146|163->146|170->153|170->153|170->153|174->157|174->157|175->158|175->158|175->158|176->159|186->169|186->169|187->170|189->172|189->172|189->172|189->172|189->172|190->173|192->175|192->175|192->175|192->175|192->175|193->176|193->176|193->176|193->176|193->176|193->176|194->177|203->186|203->186|203->186|203->186|204->187|204->187|204->187|205->188|206->189|206->189|207->190|207->190|208->191|208->191|209->192|209->192|211->194|211->194|212->195|213->196|213->196|215->198|215->198|216->199|221->204|221->204|222->205|224->207|224->207|225->208|225->208|227->210|227->210|228->211|229->212|229->212|230->213|230->213
                  -- GENERATED --
              */
          