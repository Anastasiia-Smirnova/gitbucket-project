
package gitbucket.core.admin.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object settings_authentication extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.service.OpenIDConnectService


Seq[Any](format.raw/*3.1*/("""<!--====================================================================-->
<!-- LDAP -->
<!--====================================================================-->
<fieldset>
  <label class="checkbox">
    <input type="checkbox" id="ldapAuthentication" name="ldapAuthentication""""),_display_(if(context.settings.ldap)/*8.103*/{_display_(Seq[Any](format.raw/*8.104*/(""" """),format.raw/*8.105*/("""checked""")))} else {null} ),format.raw/*8.113*/(""" """),format.raw/*8.114*/("""/>
    LDAP
  </label>
</fieldset>
<div class="ldap">
  <div class="form-group">
    <label class="control-label col-md-2" for="ldapHost">LDAP host</label>
    <div class="col-md-10">
      <input type="text" id="ldapHost" name="ldap.host" class="form-control" value=""""),_display_(/*16.86*/context/*16.93*/.settings.ldap.map(_.host)),format.raw/*16.119*/(""""/>
      <span id="error-ldap_host" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="ldapPort">LDAP port</label>
    <div class="col-md-10">
      <input type="text" id="ldapPort" name="ldap.port" class="form-control input-mini" value=""""),_display_(/*23.97*/context/*23.104*/.settings.ldap.map(_.port)),format.raw/*23.130*/(""""/>
      <span id="error-ldap_port" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="ldapBindDN">Bind DN</label>
    <div class="col-md-10">
      <input type="text" id="ldapBindDN" name="ldap.bindDN" class="form-control" value=""""),_display_(/*30.90*/context/*30.97*/.settings.ldap.map(_.bindDN)),format.raw/*30.125*/(""""/>
      <span id="error-ldap_bindDN" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="ldapBindPassword">Bind password</label>
    <div class="col-md-10">
      <input type="password" id="ldapBindPassword" name="ldap.bindPassword" class="form-control" value=""""),_display_(/*37.106*/context/*37.113*/.settings.ldap.map(_.bindPassword)),format.raw/*37.147*/(""""/>
      <span id="error-ldap_bindPassword" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="ldapBaseDN">Base DN</label>
    <div class="col-md-10">
      <input type="text" id="ldapBaseDN" name="ldap.baseDN" class="form-control" value=""""),_display_(/*44.90*/context/*44.97*/.settings.ldap.map(_.baseDN)),format.raw/*44.125*/(""""/>
      <span id="error-ldap_baseDN" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="ldapUserNameAttribute">User name attribute</label>
    <div class="col-md-10">
      <input type="text" id="ldapUserNameAttribute" name="ldap.userNameAttribute" class="form-control" value=""""),_display_(/*51.112*/context/*51.119*/.settings.ldap.map(_.userNameAttribute)),format.raw/*51.158*/(""""/>
      <span id="error-ldap_userNameAttribute" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="ldapAdditionalFilterCondition">Additional filter condition</label>
    <div class="col-md-10">
      <input type="text" id="ldapAdditionalFilterCondition" name="ldap.additionalFilterCondition" class="form-control" value=""""),_display_(/*58.128*/context/*58.135*/.settings.ldap.map(_.additionalFilterCondition)),format.raw/*58.182*/(""""/>
      <span id="error-ldap_additionalFilterCondition" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="ldapFullNameAttribute">Full name attribute</label>
    <div class="col-md-10">
      <input type="text" id="ldapFullNameAttribute" name="ldap.fullNameAttribute" class="form-control" value=""""),_display_(/*65.112*/context/*65.119*/.settings.ldap.map(_.fullNameAttribute)),format.raw/*65.158*/(""""/>
      <span id="error-ldap_fullNameAttribute" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="ldapMailAttribute">Mail address attribute</label>
    <div class="col-md-10">
      <input type="text" id="ldapMailAttribute" name="ldap.mailAttribute" class="form-control" value=""""),_display_(/*72.104*/context/*72.111*/.settings.ldap.map(_.mailAttribute)),format.raw/*72.146*/(""""/>
      <span id="error-ldap_mailAttribute" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2">Enable TLS</label>
    <div class="col-md-10">
      <input type="checkbox" name="ldap.tls""""),_display_(if(context.settings.ldap.flatMap(_.tls).getOrElse(false))/*79.103*/{_display_(Seq[Any](format.raw/*79.104*/(""" """),format.raw/*79.105*/("""checked""")))} else {null} ),format.raw/*79.113*/("""/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2">Enable SSL</label>
    <div class="col-md-10">
      <input type="checkbox" name="ldap.ssl""""),_display_(if(context.settings.ldap.flatMap(_.ssl).getOrElse(false))/*85.103*/{_display_(Seq[Any](format.raw/*85.104*/(""" """),format.raw/*85.105*/("""checked""")))} else {null} ),format.raw/*85.113*/("""/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="ldapBindDN">Keystore</label>
    <div class="col-md-10">
      <input type="text" id="ldapKeystore" name="ldap.keystore" class="form-control" value=""""),_display_(/*91.94*/context/*91.101*/.settings.ldap.map(_.keystore)),format.raw/*91.131*/(""""/>
      <span id="error-ldap_keystore" class="error"></span>
    </div>
  </div>
</div>
<!--====================================================================-->
<!-- OpenID Connect -->
<!--====================================================================-->
<hr>
<fieldset>
  <label class="checkbox">
    <input type="checkbox" id="oidcAuthentication" name="oidcAuthentication""""),_display_(if(context.settings.oidc)/*102.103*/{_display_(Seq[Any](format.raw/*102.104*/(""" """),format.raw/*102.105*/("""checked""")))} else {null} ),format.raw/*102.113*/(""" """),format.raw/*102.114*/("""/>
    OpenID Connect
  </label>
</fieldset>
<div class="oidc">
  <div class="form-group">
    <label class="control-label col-md-2" for="oidcIssuer">Issuer</label>
    <div class="col-md-10">
      <input type="text" id="oidcIssuer" name="oidc.issuer" class="form-control" value=""""),_display_(/*110.90*/context/*110.97*/.settings.oidc.map(_.issuer.getValue)),format.raw/*110.134*/(""""/>
      <span id="error-oidc_issuer" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="oidcClientID">Client ID</label>
    <div class="col-md-10">
      <input type="text" id="oidcClientID" name="oidc.clientID" class="form-control" value=""""),_display_(/*117.94*/context/*117.101*/.settings.oidc.map(_.clientID.getValue)),format.raw/*117.140*/(""""/>
      <span id="error-oidc_clientID" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="oidcClientID">Client secret</label>
    <div class="col-md-10">
      <input type="password" id="oidcClientSecret" name="oidc.clientSecret" class="form-control" value=""""),_display_(/*124.106*/context/*124.113*/.settings.oidc.map(_.clientSecret.getValue)),format.raw/*124.156*/(""""/>
      <span id="error-oidc_clientSecret" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="oidcJwsAlgorithm">Expected signature</label>
    <div class="col-md-10">
      <select id="oidcJwsAlgorithm" name="oidc.jwsAlgorithm" class="form-control">
        <option value="" """),_display_(if(context.settings.oidc.flatMap(_.jwsAlgorithm) == None)/*132.84*/{_display_(Seq[Any](format.raw/*132.85*/("""selected""")))} else {null} ),format.raw/*132.94*/(""">
          No signature
        </option>
        """),_display_(/*135.10*/OpenIDConnectService/*135.30*/.JWS_ALGORITHMS.map/*135.49*/ { case (family, algorithms) =>_display_(Seq[Any](format.raw/*135.80*/("""
          """),format.raw/*136.11*/("""<optgroup label=""""),_display_(/*136.29*/family),format.raw/*136.35*/("""">
            """),_display_(/*137.14*/algorithms/*137.24*/.map/*137.28*/ { algorithm =>_display_(Seq[Any](format.raw/*137.43*/("""
              """),format.raw/*138.15*/("""<option value=""""),_display_(/*138.31*/algorithm/*138.40*/.getName),format.raw/*138.48*/("""" """),_display_(if(context.settings.oidc.flatMap(_.jwsAlgorithm) == Some(algorithm))/*138.119*/{_display_(Seq[Any](format.raw/*138.120*/("""selected""")))} else {null} ),format.raw/*138.129*/(""">
                """),_display_(/*139.18*/algorithm/*139.27*/.getName),format.raw/*139.35*/("""
              """),format.raw/*140.15*/("""</option>
            """)))}),format.raw/*141.14*/("""
          """),format.raw/*142.11*/("""</optgroup>
        """)))}),format.raw/*143.10*/("""
      """),format.raw/*144.7*/("""</select>
      <span class="muted">Choose the expected signature algorithm of the token response. Most IdP provides RS256 or HS256.</span>
      <span id="error-oidc_jwsAlgorithm" class="error"></span>
    </div>
  </div>
</div>
<script>
$(function()"""),format.raw/*151.13*/("""{"""),format.raw/*151.14*/("""
  """),format.raw/*152.3*/("""$('#ldapAuthentication').change(function()"""),format.raw/*152.45*/("""{"""),format.raw/*152.46*/("""
    """),format.raw/*153.5*/("""$('.ldap input').prop('disabled', !$(this).prop('checked'));
  """),format.raw/*154.3*/("""}"""),format.raw/*154.4*/(""").change();

  $('#oidcAuthentication').change(function()"""),format.raw/*156.45*/("""{"""),format.raw/*156.46*/("""
    """),format.raw/*157.5*/("""$('.oidc input, .oidc select').prop('disabled', !$(this).prop('checked'));
  """),format.raw/*158.3*/("""}"""),format.raw/*158.4*/(""").change();
"""),format.raw/*159.1*/("""}"""),format.raw/*159.2*/(""");
</script>"""))
      }
    }
  }

  def render(info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(info)(context)

  def f:((Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (info) => (context) => apply(info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/admin/settings_authentication.scala.html
                  HASH: 41c65c05e391f8ff5234fab2702511876ad49657
                  MATRIX: 638->1|783->75|862->126|1195->432|1234->433|1263->434|1315->442|1344->443|1640->712|1656->719|1704->745|2036->1050|2053->1057|2101->1083|2426->1381|2442->1388|2492->1416|2848->1744|2865->1751|2921->1785|3254->2091|3270->2098|3320->2126|3693->2471|3710->2478|3771->2517|4187->2905|4204->2912|4273->2959|4665->3323|4682->3330|4743->3369|5118->3716|5135->3723|5192->3758|5526->4064|5566->4065|5596->4066|5649->4074|5918->4315|5958->4316|5988->4317|6041->4325|6315->4572|6332->4579|6384->4609|6824->5020|6865->5021|6896->5022|6950->5030|6981->5031|7291->5313|7308->5320|7368->5357|7704->5665|7722->5672|7784->5711|8139->6037|8157->6044|8223->6087|8651->6487|8691->6488|8745->6497|8825->6549|8855->6569|8884->6588|8954->6619|8994->6630|9040->6648|9068->6654|9112->6670|9132->6680|9146->6684|9200->6699|9244->6714|9288->6730|9307->6739|9337->6747|9437->6818|9478->6819|9533->6828|9580->6847|9599->6856|9629->6864|9673->6879|9728->6902|9768->6913|9821->6934|9856->6941|10136->7192|10166->7193|10197->7196|10268->7238|10298->7239|10331->7244|10422->7307|10451->7308|10537->7365|10567->7366|10600->7371|10705->7448|10734->7449|10774->7461|10803->7462
                  LINES: 14->1|17->2|20->3|25->8|25->8|25->8|25->8|25->8|33->16|33->16|33->16|40->23|40->23|40->23|47->30|47->30|47->30|54->37|54->37|54->37|61->44|61->44|61->44|68->51|68->51|68->51|75->58|75->58|75->58|82->65|82->65|82->65|89->72|89->72|89->72|96->79|96->79|96->79|96->79|102->85|102->85|102->85|102->85|108->91|108->91|108->91|119->102|119->102|119->102|119->102|119->102|127->110|127->110|127->110|134->117|134->117|134->117|141->124|141->124|141->124|149->132|149->132|149->132|152->135|152->135|152->135|152->135|153->136|153->136|153->136|154->137|154->137|154->137|154->137|155->138|155->138|155->138|155->138|155->138|155->138|155->138|156->139|156->139|156->139|157->140|158->141|159->142|160->143|161->144|168->151|168->151|169->152|169->152|169->152|170->153|171->154|171->154|173->156|173->156|174->157|175->158|175->158|176->159|176->159
                  -- GENERATED --
              */
          