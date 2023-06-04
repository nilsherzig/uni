{
    description = "go-build-env";
    inputs = { nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable"; };

    outputs = { self, nixpkgs }:
        let
        pkgs = nixpkgs.legacyPackages.x86_64-linux.pkgs;
    in {
        devShells.x86_64-linux.default = pkgs.mkShell {
            name = "pt2-lab-env";
            buildInputs = [
                pkgs.gradle
                pkgs.jdk8
            ];
        };
    };
}

