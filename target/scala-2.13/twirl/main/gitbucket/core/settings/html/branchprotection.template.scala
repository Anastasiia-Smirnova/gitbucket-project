
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object branchprotection extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[gitbucket.core.service.RepositoryService.RepositoryInfo,String,gitbucket.core.api.ApiBranchProtection,Seq[String],Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  branch: String,
  protection: gitbucket.core.api.ApiBranchProtection,
  knownContexts: Seq[String],
  info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*6.2*/import gitbucket.core.view.helpers

def /*7.2*/check/*7.7*/(bool:Boolean):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](_display_(if(bool)/*7.32*/{_display_(Seq[Any](format.raw/*7.33*/(""" """),format.raw/*7.34*/("""checked""")))} else {null} )))};
Seq[Any](format.raw/*7.43*/("""
"""),_display_(/*8.2*/gitbucket/*8.11*/.core.html.main(s"Branch protection for ${branch}", Some(repository))/*8.80*/{_display_(Seq[Any](format.raw/*8.81*/("""
  """),_display_(/*9.4*/gitbucket/*9.13*/.core.html.menu("settings", repository)/*9.52*/{_display_(Seq[Any](format.raw/*9.53*/("""
    """),_display_(/*10.6*/gitbucket/*10.15*/.core.settings.html.menu("branches", repository)/*10.63*/{_display_(Seq[Any](format.raw/*10.64*/("""
      """),_display_(/*11.8*/gitbucket/*11.17*/.core.helper.html.information(info)),format.raw/*11.52*/("""
      """),format.raw/*12.7*/("""<div class="alert alert-info" style="display:none" id="saved-info">Branch protection options saved</div>
      <form name="branchProtection" onsubmit="submitForm(event)">
        <div class="panel panel-default">
          <div class="panel-heading">Branch protection for <b>"""),_display_(/*15.64*/branch),format.raw/*15.70*/("""</b></div>
          <div class="panel-body">

            <div class="checkbox">
              <label>
                <input type="checkbox" name="enabled" onclick="update()" """),_display_(/*20.75*/check(protection.enabled)),format.raw/*20.100*/(""">
                <span class="strong">Protect this branch</span>
              </label>
              <p class="help-block">Disables force-pushes to this branch and prevents it from being deleted.</p>
            </div>
            <div class="checkbox js-enabled" style="display:none">
              <label>
                <input type="checkbox" name="has_required_statuses" onclick="update()" """),_display_(/*27.89*/check(protection.status.enforcement_level.name!="off")),format.raw/*27.143*/(""" """),_display_(if(knownContexts.isEmpty)/*27.170*/{_display_(Seq[Any](format.raw/*27.171*/("""disabled """)))} else {null} ),format.raw/*27.181*/(""">
                <span class="strong">Require status checks to pass before merging</span>
              </label>
              <p class="help-block">When enabled, commits must first be pushed to another branch, then merged or pushed directly to <b>"""),_display_(/*30.137*/branch),format.raw/*30.143*/("""</b> after status checks have passed.</p>
              """),_display_(if( knownContexts.isEmpty )/*31.43*/{_display_(Seq[Any](format.raw/*31.44*/("""
                """),format.raw/*32.17*/("""<div class="alert alert-warning">
                  Sorry, we couldn’t find any status checks in the last week for this repository.<br />
                  Please create a commit status by API (<a href="https://developer.github.com/v3/repos/statuses/">Learn more about status checks on GitHub</a>)
                </div>
              """)))}else/*36.22*/{_display_(Seq[Any](format.raw/*36.23*/("""
                """),format.raw/*37.17*/("""<div class="js-has_required_statuses" style="display:none">
                  <div class="panel panel-default">
                    <div class="panel-heading">Choose which status checks must pass before branches can be merged into <b>"""),_display_(/*39.124*/branch),format.raw/*39.130*/("""</b>.</div>
                    <div class="panel-body">
                      """),_display_(/*41.24*/knownContexts/*41.37*/.map/*41.41*/ { context =>_display_(Seq[Any](format.raw/*41.54*/("""
                        """),format.raw/*42.25*/("""<div class="checkbox">
                          <label>
                            <input type="checkbox" name="contexts" value=""""),_display_(/*44.76*/context),format.raw/*44.83*/("""" onclick="update()" """),_display_(/*44.105*/check(protection.status.contexts.find(_ == context))),format.raw/*44.157*/(""">
                            <span>"""),_display_(/*45.36*/context),format.raw/*45.43*/("""</span>
                          </label>
                        </div>
                      """)))}),format.raw/*48.24*/("""
                    """),format.raw/*49.21*/("""</div>
                  </div>

                  <div class="checkbox">
                    <label>
                      <input type="checkbox" name="enforce_for_admins" onclick="update()" """),_display_(/*54.92*/check(protection.status.enforcement_level.name=="everyone")),format.raw/*54.151*/(""">
                      <span class="strong">Include administrators</span>
                    </label>
                    <p class="help-block">Enforce required status checks for repository administrators.</p>
                  </div>
                </div>
              """)))}),format.raw/*60.16*/("""
            """),format.raw/*61.13*/("""</div>
            <input class="btn btn-success js-submit-btn" type="submit" value="Save changes" />
          </div>
        </div>
      </form>
    """)))}),format.raw/*66.6*/("""
  """)))}),format.raw/*67.4*/("""
""")))}),format.raw/*68.2*/("""
"""),format.raw/*69.1*/("""<script>
function getValue()"""),format.raw/*70.20*/("""{"""),format.raw/*70.21*/("""
  """),format.raw/*71.3*/("""var v = """),format.raw/*71.11*/("""{"""),format.raw/*71.12*/("""}"""),format.raw/*71.13*/(""", contexts=[];
  $("input[type=checkbox]:checked").each(function()"""),format.raw/*72.52*/("""{"""),format.raw/*72.53*/("""
    """),format.raw/*73.5*/("""if(this.name === 'contexts')"""),format.raw/*73.33*/("""{"""),format.raw/*73.34*/("""
      """),format.raw/*74.7*/("""contexts.push(this.value);
    """),format.raw/*75.5*/("""}"""),format.raw/*75.6*/(""" """),format.raw/*75.7*/("""else """),format.raw/*75.12*/("""{"""),format.raw/*75.13*/("""
      """),format.raw/*76.7*/("""v[this.name] = true;
    """),format.raw/*77.5*/("""}"""),format.raw/*77.6*/("""
  """),format.raw/*78.3*/("""}"""),format.raw/*78.4*/(""");
  if(v.enabled)"""),format.raw/*79.16*/("""{"""),format.raw/*79.17*/("""
    """),format.raw/*80.5*/("""return """),format.raw/*80.12*/("""{"""),format.raw/*80.13*/("""
      """),format.raw/*81.7*/("""enabled: true,
      required_status_checks: """),format.raw/*82.31*/("""{"""),format.raw/*82.32*/("""
        """),format.raw/*83.9*/("""enforcement_level: v.has_required_statuses ? ((v.enforce_for_admins ? 'everyone' : 'non_admins')) : 'off',
        contexts: v.has_required_statuses ? contexts : []
      """),format.raw/*85.7*/("""}"""),format.raw/*85.8*/("""
    """),format.raw/*86.5*/("""}"""),format.raw/*86.6*/(""";
  """),format.raw/*87.3*/("""}"""),format.raw/*87.4*/(""" """),format.raw/*87.5*/("""else """),format.raw/*87.10*/("""{"""),format.raw/*87.11*/("""
    """),format.raw/*88.5*/("""return """),format.raw/*88.12*/("""{"""),format.raw/*88.13*/("""
      """),format.raw/*89.7*/("""enabled: false,
      required_status_checks: """),format.raw/*90.31*/("""{"""),format.raw/*90.32*/("""
        """),format.raw/*91.9*/("""enforcement_level: "off",
        contexts: []
      """),format.raw/*93.7*/("""}"""),format.raw/*93.8*/("""
    """),format.raw/*94.5*/("""}"""),format.raw/*94.6*/(""";
  """),format.raw/*95.3*/("""}"""),format.raw/*95.4*/("""
"""),format.raw/*96.1*/("""}"""),format.raw/*96.2*/("""
"""),format.raw/*97.1*/("""function updateView(protection)"""),format.raw/*97.32*/("""{"""),format.raw/*97.33*/("""
  """),format.raw/*98.3*/("""$('.js-enabled').toggle(protection.enabled);
  $('.js-has_required_statuses').toggle(protection.required_status_checks.enforcement_level != 'off');
  $('.js-submit-btn').attr('disabled',protection.required_status_checks.enforcement_level != 'off' && protection.required_status_checks.contexts.length == 0);
"""),format.raw/*101.1*/("""}"""),format.raw/*101.2*/("""
"""),format.raw/*102.1*/("""function update()"""),format.raw/*102.18*/("""{"""),format.raw/*102.19*/("""
  """),format.raw/*103.3*/("""var protection = getValue();
  updateView(protection);
"""),format.raw/*105.1*/("""}"""),format.raw/*105.2*/("""
"""),format.raw/*106.1*/("""$(update);
function submitForm(e)"""),format.raw/*107.23*/("""{"""),format.raw/*107.24*/("""
  """),format.raw/*108.3*/("""e.stopPropagation();
  e.preventDefault();
  var protection = getValue();
  $.ajax("""),format.raw/*111.10*/("""{"""),format.raw/*111.11*/("""
    """),format.raw/*112.5*/("""method:'PATCH',
    url:'"""),_display_(/*113.11*/context/*113.18*/.path),format.raw/*113.23*/("""/api/v3/repos/"""),_display_(/*113.38*/repository/*113.48*/.owner),format.raw/*113.54*/("""/"""),_display_(/*113.56*/repository/*113.66*/.name),format.raw/*113.71*/("""/branches/"""),_display_(/*113.82*/helpers/*113.89*/.urlEncode(branch)),format.raw/*113.107*/("""',
    contentType: 'application/json',
    dataType: 'json',
    data:JSON.stringify("""),format.raw/*116.25*/("""{"""),format.raw/*116.26*/("""protection:protection"""),format.raw/*116.47*/("""}"""),format.raw/*116.48*/("""),
    success:function(r)"""),format.raw/*117.24*/("""{"""),format.raw/*117.25*/("""
      """),format.raw/*118.7*/("""$('#saved-info').show();
    """),format.raw/*119.5*/("""}"""),format.raw/*119.6*/(""",
    error:function(err)"""),format.raw/*120.24*/("""{"""),format.raw/*120.25*/("""
      """),format.raw/*121.7*/("""console.log(err);
      alert('update error');
    """),format.raw/*123.5*/("""}"""),format.raw/*123.6*/("""
  """),format.raw/*124.3*/("""}"""),format.raw/*124.4*/(""");
"""),format.raw/*125.1*/("""}"""),format.raw/*125.2*/("""
"""),format.raw/*126.1*/("""</script>
"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,branch:String,protection:gitbucket.core.api.ApiBranchProtection,knownContexts:Seq[String],info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,branch,protection,knownContexts,info)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo,String,gitbucket.core.api.ApiBranchProtection,Seq[String],Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,branch,protection,knownContexts,info) => (context) => apply(repository,branch,protection,knownContexts,info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/branchprotection.scala.html
                  HASH: a958a0315ad61f0752ef6e4a17dc78fd095a2242
                  MATRIX: 748->1|1066->248|1113->284|1125->289|1227->314|1265->315|1293->316|1357->325|1384->327|1401->336|1478->405|1516->406|1545->410|1562->419|1609->458|1647->459|1679->465|1697->474|1754->522|1793->523|1827->531|1845->540|1901->575|1935->582|2238->858|2265->864|2470->1042|2517->1067|2942->1465|3018->1519|3073->1546|3113->1547|3168->1557|3446->1807|3474->1813|3585->1897|3624->1898|3669->1915|4028->2257|4067->2258|4112->2275|4375->2510|4403->2516|4510->2596|4532->2609|4545->2613|4596->2626|4649->2651|4808->2783|4836->2790|4886->2812|4960->2864|5024->2901|5052->2908|5180->3005|5229->3026|5449->3219|5530->3278|5836->3553|5877->3566|6060->3719|6094->3723|6126->3725|6154->3726|6210->3754|6239->3755|6269->3758|6305->3766|6334->3767|6363->3768|6457->3834|6486->3835|6518->3840|6574->3868|6603->3869|6637->3876|6695->3907|6723->3908|6751->3909|6784->3914|6813->3915|6847->3922|6899->3947|6927->3948|6957->3951|6985->3952|7031->3970|7060->3971|7092->3976|7127->3983|7156->3984|7190->3991|7263->4036|7292->4037|7328->4046|7526->4217|7554->4218|7586->4223|7614->4224|7645->4228|7673->4229|7701->4230|7734->4235|7763->4236|7795->4241|7830->4248|7859->4249|7893->4256|7967->4302|7996->4303|8032->4312|8112->4365|8140->4366|8172->4371|8200->4372|8231->4376|8259->4377|8287->4378|8315->4379|8343->4380|8402->4411|8431->4412|8461->4415|8796->4722|8825->4723|8854->4724|8900->4741|8930->4742|8961->4745|9044->4800|9073->4801|9102->4802|9164->4835|9194->4836|9225->4839|9337->4922|9367->4923|9400->4928|9454->4954|9471->4961|9498->4966|9541->4981|9561->4991|9589->4997|9619->4999|9639->5009|9666->5014|9705->5025|9722->5032|9763->5050|9878->5136|9908->5137|9958->5158|9988->5159|10043->5185|10073->5186|10108->5193|10165->5222|10194->5223|10248->5248|10278->5249|10313->5256|10392->5307|10421->5308|10452->5311|10481->5312|10512->5315|10541->5316|10570->5317
                  LINES: 14->1|21->6|23->7|23->7|25->7|25->7|25->7|26->7|27->8|27->8|27->8|27->8|28->9|28->9|28->9|28->9|29->10|29->10|29->10|29->10|30->11|30->11|30->11|31->12|34->15|34->15|39->20|39->20|46->27|46->27|46->27|46->27|46->27|49->30|49->30|50->31|50->31|51->32|55->36|55->36|56->37|58->39|58->39|60->41|60->41|60->41|60->41|61->42|63->44|63->44|63->44|63->44|64->45|64->45|67->48|68->49|73->54|73->54|79->60|80->61|85->66|86->67|87->68|88->69|89->70|89->70|90->71|90->71|90->71|90->71|91->72|91->72|92->73|92->73|92->73|93->74|94->75|94->75|94->75|94->75|94->75|95->76|96->77|96->77|97->78|97->78|98->79|98->79|99->80|99->80|99->80|100->81|101->82|101->82|102->83|104->85|104->85|105->86|105->86|106->87|106->87|106->87|106->87|106->87|107->88|107->88|107->88|108->89|109->90|109->90|110->91|112->93|112->93|113->94|113->94|114->95|114->95|115->96|115->96|116->97|116->97|116->97|117->98|120->101|120->101|121->102|121->102|121->102|122->103|124->105|124->105|125->106|126->107|126->107|127->108|130->111|130->111|131->112|132->113|132->113|132->113|132->113|132->113|132->113|132->113|132->113|132->113|132->113|132->113|132->113|135->116|135->116|135->116|135->116|136->117|136->117|137->118|138->119|138->119|139->120|139->120|140->121|142->123|142->123|143->124|143->124|144->125|144->125|145->126
                  -- GENERATED --
              */
          