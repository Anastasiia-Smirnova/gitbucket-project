
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object edithookform extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[gitbucket.core.model.WebHook,Set[gitbucket.core.model.WebHook.Event],Boolean,String,String,String,String,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(webHook: gitbucket.core.model.WebHook,
  events: Set[gitbucket.core.model.WebHook.Event],
  create: Boolean,
  newButtonUrl: String,
  editButtonUrl: String,
  deleteButtonUrl: String,
  testButtonUrl: String)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*8.2*/import gitbucket.core.view.helpers
/*9.2*/import gitbucket.core.model.WebHook._
/*10.2*/import gitbucket.core.model.WebHookContentType

def /*11.2*/check/*11.7*/(name: String, event: Event):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*11.39*/("""
  """),format.raw/*12.3*/("""name=""""),_display_(/*12.10*/(name)),format.raw/*12.16*/("""."""),_display_(/*12.18*/event/*12.23*/.name),format.raw/*12.28*/("""" value="on" """),_display_(if(events(event))/*12.59*/{_display_(Seq[Any](format.raw/*12.60*/("""checked""")))} else {null} ),format.raw/*12.68*/("""
""")))};
Seq[Any](format.raw/*13.2*/("""
"""),format.raw/*14.1*/("""<div class="panel panel-default">
  <div class="panel-heading strong">Webhook / Manage webhook</div>
  <div class="panel-body">
    <form method="POST" validate="true" autocomplete="off">
      <fieldset class="form-group">
        <label class="strong" for="url">Payload URL</label>
        <div>
          <span class="error" id="error-url"></span>
        </div>
        """),_display_(if(create)/*23.20*/{_display_(Seq[Any](format.raw/*23.21*/("""
          """),format.raw/*24.11*/("""<input type="text" name="url" id="url" value=""""),_display_(/*24.58*/webHook/*24.65*/.url),format.raw/*24.69*/("""" class="form-control" style="display: inline; width: 500px; vertical-align: middle;" required />
        """)))}else/*25.16*/{_display_(Seq[Any](format.raw/*25.17*/("""
          """),format.raw/*26.11*/("""<input type="text" value=""""),_display_(/*26.38*/webHook/*26.45*/.url),format.raw/*26.49*/("""" class="form-control" style="display: inline; width: 500px; vertical-align: middle;" disabled />
          <input type="hidden" value=""""),_display_(/*27.40*/webHook/*27.47*/.url),format.raw/*27.51*/("""" name="url" />
        """)))}),format.raw/*28.10*/("""
        """),format.raw/*29.9*/("""<button class="btn btn-default" id="test-hook">Test Hook</button>
      </fieldset>
      <fieldset class="form-group">
        <label class="strong" for="ctype">Content type</label>
        <div></div>
        <select name="ctype" id="ctype" class="form-control" style="width: 500px;">
          <option value=""""),_display_(/*35.27*/WebHookContentType/*35.45*/.FORM.code),format.raw/*35.55*/("""" """),_display_(if(webHook.ctype == WebHookContentType.FORM)/*35.102*/{_display_(Seq[Any](format.raw/*35.103*/("""selected""")))} else {null} ),format.raw/*35.112*/(""">"""),_display_(/*35.114*/WebHookContentType/*35.132*/.FORM.ctype),format.raw/*35.143*/("""</option>
          <option value=""""),_display_(/*36.27*/WebHookContentType/*36.45*/.JSON.code),format.raw/*36.55*/("""" """),_display_(if(webHook.ctype == WebHookContentType.JSON)/*36.102*/{_display_(Seq[Any](format.raw/*36.103*/("""selected""")))} else {null} ),format.raw/*36.112*/(""">"""),_display_(/*36.114*/WebHookContentType/*36.132*/.JSON.ctype),format.raw/*36.143*/("""</option>
        </select>
      </fieldset>
      <fieldset class="form-group">
        <label class="strong" for="token">Security Token</label>
        <div></div>
        <input type="text" name="token" id="token" placeholder="leave blank for no X-Hub-Signature usage" value=""""),_display_(/*42.115*/webHook/*42.122*/.token),format.raw/*42.128*/("""" class="form-control" style="display: inline; width: 500px; vertical-align: middle;" />
      </fieldset>
      <hr />
      <label class="strong">Which events would you like to trigger this webhook?</label>
      <div>
        <span class="error" id="error-events"></span>
      </div>
      <!--
      <label class="checkbox"><input type="checkbox" """),_display_(/*50.55*/check("events",CommitComment)),format.raw/*50.84*/(""" """),format.raw/*50.85*/("""/>Commit comment <small class="help-block">Commit or diff commented on. </small> </label>
      -->
      <label class="checkbox"><input type="checkbox" """),_display_(/*52.55*/check("events",Create)),format.raw/*52.77*/(""" """),format.raw/*52.78*/("""/>Create <small class="help-block normal">Branch, or tag created. </small> </label>
      <!--
      <label class="checkbox"><input type="checkbox" """),_display_(/*54.55*/check("events",Delete)),format.raw/*54.77*/(""" """),format.raw/*54.78*/("""/>Delete <small class="help-block">Branch, or tag deleted. </small> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*55.55*/check("events",Deployment)),format.raw/*55.81*/(""" """),format.raw/*55.82*/("""/>Deployment <small class="help-block">Repository deployed. </small> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*56.55*/check("events",DeploymentStatus)),format.raw/*56.87*/(""" """),format.raw/*56.88*/("""/>Deployment status <small class="help-block">Deployment status updated from the API. </small> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*57.55*/check("events",Fork)),format.raw/*57.75*/(""" """),format.raw/*57.76*/("""/>Fork <small class="help-block">Repository forked. </small> </label>
      -->
      <label class="checkbox"><input type="checkbox" """),_display_(/*59.55*/check("events",Gollum)),format.raw/*59.77*/(""" """),format.raw/*59.78*/("""/>Gollum <span class="help-block normal">Wiki page updated. </span> </label>
      <!--
      <label class="checkbox"><input type="checkbox" """),_display_(/*61.55*/check("events",Member)),format.raw/*61.77*/(""" """),format.raw/*61.78*/("""/>Member <small class="help-block">Collaborator added to a non-organization repository. </small> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*62.55*/check("events",PageBuild)),format.raw/*62.80*/(""" """),format.raw/*62.81*/("""/>Page build <small class="help-block">Pages site built. </small> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*63.55*/check("events",Public)),format.raw/*63.77*/(""" """),format.raw/*63.78*/("""/>Public <small class="help-block">Repository changes from private to public. </small> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*64.55*/check("events",Release)),format.raw/*64.78*/(""" """),format.raw/*64.79*/("""/>Release <small class="help-block">Release published in a repository. </small> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*65.55*/check("events",TeamAdd)),format.raw/*65.78*/(""" """),format.raw/*65.79*/("""/>Team add <small class="help-block">Team added or modified on a repository. </small> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*66.55*/check("events",Watch)),format.raw/*66.76*/(""" """),format.raw/*66.77*/("""/>Watch <small class="help-block">User stars a repository.</small></label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*67.55*/check("events",Status)),format.raw/*67.77*/(""" """),format.raw/*67.78*/("""/>Status <small class="help-block">Commit status updated from the API. </small> </label>
      -->
      <label class="checkbox"><input type="checkbox" """),_display_(/*69.55*/check("events",IssueComment)),format.raw/*69.83*/(""" """),format.raw/*69.84*/("""/>Issue comment <span class="help-block normal">Issue commented on. </span> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*70.55*/check("events",Issues)),format.raw/*70.77*/(""" """),format.raw/*70.78*/("""/>Issues <span class="help-block normal">Issue opened, closed<!-- , assigned, or labeled -->. </span> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*71.55*/check("events",PullRequest)),format.raw/*71.82*/(""" """),format.raw/*71.83*/("""/>Pull request <span class="help-block normal">Pull request opened, closed<!-- , assigned, labeled -->, or synchronized. </span> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*72.55*/check("events",PullRequestReviewComment)),format.raw/*72.95*/(""" """),format.raw/*72.96*/("""/>Pull request review comment <span class="help-block normal">Pull request diff commented on. </span> </label>
      <label class="checkbox"><input type="checkbox" """),_display_(/*73.55*/check("events",Push)),format.raw/*73.75*/(""" """),format.raw/*73.76*/("""/>Push <span class="help-block normal">Git push to a repository. </span> </label>
      <div class="text-right">
      """),_display_(if(!create)/*75.19*/{_display_(Seq[Any](format.raw/*75.20*/("""
        """),format.raw/*76.9*/("""<input type="submit" class="btn btn-success" value="Update webhook" formaction=""""),_display_(/*76.90*/editButtonUrl),format.raw/*76.103*/("""" />
        <a href=""""),_display_(/*77.19*/deleteButtonUrl),format.raw/*77.34*/("""?url="""),_display_(/*77.40*/helpers/*77.47*/.urlEncode(webHook.url)),format.raw/*77.70*/("""" class="btn btn-danger" onclick="return confirm('delete webhook for """),_display_(/*77.140*/webHook/*77.147*/.url),format.raw/*77.151*/(""" """),format.raw/*77.152*/("""?')">
          Delete webhook
        </a>
      """)))}else/*80.14*/{_display_(Seq[Any](format.raw/*80.15*/("""
        """),format.raw/*81.9*/("""<input type="submit" class="btn btn-success" value="Add webhook" formaction=""""),_display_(/*81.87*/newButtonUrl),format.raw/*81.99*/("""" />
      """)))}),format.raw/*82.8*/("""
      """),format.raw/*83.7*/("""</div>
    </form>
  </div>
</div>
<div class="modal" id="test-report-modal" role="dialog" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3>WebHook Test</h3>
      </div>
      <div class="modal-body" style="max-height: 300px; overflow: auto;">
        <p>request to <span id="test-modal-url" style="word-break: break-all; word-wrap: break-word; white-space: pre; white-space: pre-wrap;"></span></p>
        <div id="test-report" style="display:none">
          <ul class="nav nav-tabs" id="test-report-tab">
            <li class="active"><a href="#request">Request</a></li>
            <li><a href="#response">Response <span class="label label-success" id="res-status"></span></a></li>
          </ul>
          <div class="tab-content">
            <div class="tab-pane active" id="request">
              <div id="req-errors" class="alert alert-error">
                      ERROR<span id="req-errors-body"></span>
                    </div>
              <div id="req-success" style="display:none">
                      Headers
                <pre id="req-headers"></pre>
                Payload
                <pre id="req-payload"></pre>
              </div>
            </div>
            <div class="tab-pane" id="response">
              <div id="res-errors" class="alert alert-error">
                      ERROR<span id="res-errors-body"></span>
                    </div>
              <div id="res-success" style="display:none">
                      Headers
                <pre id="res-headers"></pre>
                Body
                <pre id="res-body"></pre>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
$(function()"""),format.raw/*131.13*/("""{"""),format.raw/*131.14*/("""
  """),format.raw/*132.3*/("""$('#test-report-tab a').click(function (e) """),format.raw/*132.46*/("""{"""),format.raw/*132.47*/("""
    """),format.raw/*133.5*/("""e.preventDefault();
    $(this).tab('show');
  """),format.raw/*135.3*/("""}"""),format.raw/*135.4*/(""");
  $('#test-hook').click(function(e)"""),format.raw/*136.36*/("""{"""),format.raw/*136.37*/("""
    """),format.raw/*137.5*/("""e.stopPropagation();
    e.stopImmediatePropagation();
    e.preventDefault();
    const url = this.form.url.value;
    const token = this.form.token.value;
    const ctype = this.form.ctype.value;
    if(!/^https?:\/\/.+/.test(url))"""),format.raw/*143.36*/("""{"""),format.raw/*143.37*/("""
      """),format.raw/*144.7*/("""alert("invalid url");
      return;
    """),format.raw/*146.5*/("""}"""),format.raw/*146.6*/("""
    """),format.raw/*147.5*/("""$("#test-modal-url").text(url)
    $("#test-report-modal").modal('show')
    $("#test-report").hide();
    let targetUrl = '"""),_display_(/*150.23*/testButtonUrl),format.raw/*150.36*/("""?url=' + encodeURIComponent(url) + '&ctype=' + ctype + '&token=';
    if (token) """),format.raw/*151.16*/("""{"""),format.raw/*151.17*/("""
      """),format.raw/*152.7*/("""targetUrl = targetUrl + encodeURIComponent(token);
    """),format.raw/*153.5*/("""}"""),format.raw/*153.6*/("""
    """),format.raw/*154.5*/("""$.ajax("""),format.raw/*154.12*/("""{"""),format.raw/*154.13*/("""
      """),format.raw/*155.7*/("""method: 'POST',
      url: targetUrl,
      success: function(e)"""),format.raw/*157.27*/("""{"""),format.raw/*157.28*/("""
        """),format.raw/*158.9*/("""$('#test-report-tab a:first').tab('show');
        $("#test-report").show();
        $("#req-success").toggle(e.request && !e.request.error);
        $("#req-errors").toggle(e.request && !!e.request.error);
        $("#req-errors-body").text(e.request.error);
        function headers(h)"""),format.raw/*163.28*/("""{"""),format.raw/*163.29*/("""
          """),format.raw/*164.11*/("""h = h["headers"];
          return h ? $.map(h, function(h)"""),format.raw/*165.42*/("""{"""),format.raw/*165.43*/("""
            """),format.raw/*166.13*/("""return $("<div>").append($('<b>').text(h[0] + ":"),$('<span>').text(" " + h[1]))
          """),format.raw/*167.11*/("""}"""),format.raw/*167.12*/("""):"";
        """),format.raw/*168.9*/("""}"""),format.raw/*168.10*/("""
        """),format.raw/*169.9*/("""$("#req-headers").html(headers(e.request));
        $("#req-payload").text(e.request && e.request.payload ? JSON.stringify(JSON.parse(e.request.payload),undefined,4) : "");
        $("#res-success").toggle(e.response && !e.response.error);
        $("#res-errors").toggle(e.response && !!e.response.error);
        $("#res-errors-body").text(e.response.error);
        const success = !!(e.response && e.response.status && /^2\d\d$/.test(e.response.status));
        $("#res-status").text((e.response && e.response.status) || "ERROR");
        $("#res-status").toggleClass("label-success", success).toggleClass("label-danger", !success);
        $("#res-headers").html(headers(e.response));
        $("#res-body").text(e.response && e.response.body ? e.response.body : "");
      """),format.raw/*179.7*/("""}"""),format.raw/*179.8*/(""",
      error:function (e) """),format.raw/*180.26*/("""{"""),format.raw/*180.27*/("""
        """),format.raw/*181.9*/("""if(e) """),format.raw/*181.15*/("""{"""),format.raw/*181.16*/("""
          """),format.raw/*182.11*/("""console.log(e.responseText, e);
          alert("request error ( http status " + e.status + " error on gitbucket or browser to gitbucket. show details on your javascript console )");
        """),format.raw/*184.9*/("""}"""),format.raw/*184.10*/("""else"""),format.raw/*184.14*/("""{"""),format.raw/*184.15*/("""
          """),format.raw/*185.11*/("""alert("unknown javascript error (please report to gitbucket team)");
        """),format.raw/*186.9*/("""}"""),format.raw/*186.10*/("""
        """),format.raw/*187.9*/("""$("#test-report-modal").modal('hide')
      """),format.raw/*188.7*/("""}"""),format.raw/*188.8*/("""
    """),format.raw/*189.5*/("""}"""),format.raw/*189.6*/(""");
    return false;
  """),format.raw/*191.3*/("""}"""),format.raw/*191.4*/(""");
"""),format.raw/*192.1*/("""}"""),format.raw/*192.2*/(""")
</script>
"""))
      }
    }
  }

  def render(webHook:gitbucket.core.model.WebHook,events:Set[gitbucket.core.model.WebHook.Event],create:Boolean,newButtonUrl:String,editButtonUrl:String,deleteButtonUrl:String,testButtonUrl:String,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(webHook,events,create,newButtonUrl,editButtonUrl,deleteButtonUrl,testButtonUrl)(context)

  def f:((gitbucket.core.model.WebHook,Set[gitbucket.core.model.WebHook.Event],Boolean,String,String,String,String) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (webHook,events,create,newButtonUrl,editButtonUrl,deleteButtonUrl,testButtonUrl) => (context) => apply(webHook,events,create,newButtonUrl,editButtonUrl,deleteButtonUrl,testButtonUrl)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/edithookform.scala.html
                  HASH: 7cb3b56ce7a3da753f3ebe56308e476710d44676
                  MATRIX: 723->1|1059->266|1101->302|1147->341|1207->389|1220->394|1329->426|1359->429|1393->436|1420->442|1449->444|1463->449|1489->454|1547->485|1586->486|1638->494|1679->496|1707->497|2119->882|2158->883|2197->894|2271->941|2287->948|2312->952|2442->1065|2481->1066|2520->1077|2574->1104|2590->1111|2615->1115|2779->1252|2795->1259|2820->1263|2876->1288|2912->1297|3252->1610|3279->1628|3310->1638|3385->1685|3425->1686|3479->1695|3509->1697|3537->1715|3570->1726|3633->1762|3660->1780|3691->1790|3766->1837|3806->1838|3860->1847|3890->1849|3918->1867|3951->1878|4260->2159|4277->2166|4305->2172|4685->2525|4735->2554|4764->2555|4945->2709|4988->2731|5017->2732|5193->2881|5236->2903|5265->2904|5423->3035|5470->3061|5499->3062|5658->3194|5711->3226|5740->3227|5925->3385|5966->3405|5995->3406|6156->3540|6199->3562|6228->3563|6397->3705|6440->3727|6469->3728|6656->3888|6702->3913|6731->3914|6887->4043|6930->4065|6959->4066|7136->4216|7180->4239|7209->4240|7379->4383|7423->4406|7452->4407|7628->4556|7670->4577|7699->4578|7855->4707|7898->4729|7927->4730|8107->4883|8156->4911|8185->4912|8351->5051|8394->5073|8423->5074|8615->5239|8663->5266|8692->5267|8911->5459|8972->5499|9001->5500|9193->5665|9234->5685|9263->5686|9421->5817|9460->5818|9496->5827|9604->5908|9639->5921|9689->5944|9725->5959|9758->5965|9774->5972|9818->5995|9916->6065|9933->6072|9959->6076|9989->6077|10063->6134|10102->6135|10138->6144|10243->6222|10276->6234|10318->6246|10352->6253|12334->8206|12364->8207|12395->8210|12467->8253|12497->8254|12530->8259|12605->8306|12634->8307|12701->8345|12731->8346|12764->8351|13026->8584|13056->8585|13091->8592|13159->8632|13188->8633|13221->8638|13374->8763|13409->8776|13519->8857|13549->8858|13584->8865|13667->8920|13696->8921|13729->8926|13765->8933|13795->8934|13830->8941|13923->9005|13953->9006|13990->9015|14306->9302|14336->9303|14376->9314|14464->9373|14494->9374|14536->9387|14656->9478|14686->9479|14728->9493|14758->9494|14795->9503|15603->10283|15632->10284|15688->10311|15718->10312|15755->10321|15790->10327|15820->10328|15860->10339|16079->10530|16109->10531|16142->10535|16172->10536|16212->10547|16317->10624|16347->10625|16384->10634|16456->10678|16485->10679|16518->10684|16547->10685|16598->10708|16627->10709|16658->10712|16687->10713
                  LINES: 14->1|23->8|24->9|25->10|27->11|27->11|29->11|30->12|30->12|30->12|30->12|30->12|30->12|30->12|30->12|30->12|32->13|33->14|42->23|42->23|43->24|43->24|43->24|43->24|44->25|44->25|45->26|45->26|45->26|45->26|46->27|46->27|46->27|47->28|48->29|54->35|54->35|54->35|54->35|54->35|54->35|54->35|54->35|54->35|55->36|55->36|55->36|55->36|55->36|55->36|55->36|55->36|55->36|61->42|61->42|61->42|69->50|69->50|69->50|71->52|71->52|71->52|73->54|73->54|73->54|74->55|74->55|74->55|75->56|75->56|75->56|76->57|76->57|76->57|78->59|78->59|78->59|80->61|80->61|80->61|81->62|81->62|81->62|82->63|82->63|82->63|83->64|83->64|83->64|84->65|84->65|84->65|85->66|85->66|85->66|86->67|86->67|86->67|88->69|88->69|88->69|89->70|89->70|89->70|90->71|90->71|90->71|91->72|91->72|91->72|92->73|92->73|92->73|94->75|94->75|95->76|95->76|95->76|96->77|96->77|96->77|96->77|96->77|96->77|96->77|96->77|96->77|99->80|99->80|100->81|100->81|100->81|101->82|102->83|150->131|150->131|151->132|151->132|151->132|152->133|154->135|154->135|155->136|155->136|156->137|162->143|162->143|163->144|165->146|165->146|166->147|169->150|169->150|170->151|170->151|171->152|172->153|172->153|173->154|173->154|173->154|174->155|176->157|176->157|177->158|182->163|182->163|183->164|184->165|184->165|185->166|186->167|186->167|187->168|187->168|188->169|198->179|198->179|199->180|199->180|200->181|200->181|200->181|201->182|203->184|203->184|203->184|203->184|204->185|205->186|205->186|206->187|207->188|207->188|208->189|208->189|210->191|210->191|211->192|211->192
                  -- GENERATED --
              */
          