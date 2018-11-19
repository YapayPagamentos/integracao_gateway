
lib = File.expand_path("../lib", __FILE__)
$LOAD_PATH.unshift(lib) unless $LOAD_PATH.include?(lib)
require "yapay_gw/version"

Gem::Specification.new do |spec|
  spec.name          = "yapay_gw"
  spec.version       = YapayGw::VERSION
  spec.authors       = ["Ivan Simionato"]
  spec.email         = ["ivan.simionato@yapay.com.br"]

  spec.summary       = "Integração Yapay Gateway"
  spec.description   = "Essa gem foi criada para facilitar a integração com o gateway de pagamentos da Yapay"
  spec.homepage      = "https://www.yapay.com.br/gateway-de-pagamento"

  spec.files         = Dir.chdir(File.expand_path('..', __FILE__)) do
    `git ls-files -z`.split("\x0").reject { |f| f.match(%r{^(test|spec|features)/}) }
  end
  spec.bindir        = "exe"
  spec.executables   = spec.files.grep(%r{^exe/}) { |f| File.basename(f) }
  spec.require_paths = ["lib"]

  spec.required_ruby_version = ">= 2.3.3"

  spec.add_development_dependency "bundler", "~> 1.16"
  spec.add_development_dependency "rake", "~> 10.0"
  spec.add_development_dependency "rspec", "~> 3.0"
  spec.add_runtime_dependency "http", "~> 3.3"

end
